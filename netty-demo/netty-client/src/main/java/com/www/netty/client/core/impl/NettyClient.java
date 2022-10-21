package com.www.netty.client.core.impl;

import com.www.netty.client.core.INettyClient;
import com.www.netty.client.handler.NettyResponseHandler;
import com.www.netty.client.store.RpcFuture;
import com.www.netty.client.store.RpcResponseCache;
import com.www.netty.core.coder.NettyDecoder;
import com.www.netty.core.coder.NettyEncoder;
import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageConstants;
import com.www.netty.core.protocol.MessageEnum;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * <p>@Description netty客户端实现类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:06 </p>
 */
@Slf4j
public class NettyClient implements INettyClient {
    private Bootstrap bootstrap;
    private EventLoopGroup loopGroup;
    /**
     * <p>@Description 构造方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:27  </p>
     * @return
     */
    public NettyClient(){
        //创建客户端循环数组
        loopGroup = new NioEventLoopGroup();
        try {
            bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)//设置客户端通道实现类
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new NettyDecoder())
                                    .addLast(new NettyEncoder())
                                    .addLast(new NettyResponseHandler());//添加处理器
                        }
                    });
            log.info("客户端准备就绪。。。");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    /**
     * <p>@Description 发送请求 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/17 17:17  </p>
     * @param ip 请求ip
     * @param port 请求端口
     * @param protocol 请求协议
     * @return java.lang.Object 响应内容
     */
    @Override
    public MessageProtocol<NettyResponse> sendRequest(String ip,int port,MessageProtocol protocol) {
        try {
            ChannelFuture channelFuture = bootstrap.connect(ip,port).sync();
            //将异步返回结果保存到缓存中
            RpcFuture<MessageProtocol<NettyResponse>> future = new RpcFuture<>();
            RpcResponseCache.add(protocol.getHeader().getRequestId(),future);
            channelFuture.addListener(arg -> {
                if (channelFuture.isSuccess()){
                    log.info("ip:{}, 端口：{} 请求成功。。。。",ip,port);
                }else {
                    log.info("ip:{}, 端口：{} 请求失败。。。。",ip,port);
                    channelFuture.cause().printStackTrace();
                    loopGroup.shutdownGracefully();
                }
            });
            channelFuture.channel().writeAndFlush(protocol);
            //通过异步获取结果
            return future.get();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
