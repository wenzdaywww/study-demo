package com.www.netty.sever.core;

import com.www.netty.core.coder.NettyDecoder;
import com.www.netty.core.coder.NettyEncoder;
import com.www.netty.sever.config.NettyServerProperies;
import com.www.netty.sever.handler.NettyRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@Description netty服务端 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:08 </p>
 */
@Slf4j
public class NettyServer {
    private NettyServerProperies nettyServerProperies;
    /**
     * <p>@Description 构造方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:21  </p>
     * @return
     */
    public NettyServer(NettyServerProperies nettyServerProperies){
        this.nettyServerProperies = nettyServerProperies;
        startServer();
    }
    /**
     * <p>@Description 启动netty服务端 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 9:06  </p>
     * @return void
     */
    public void startServer(){
        /*
         * bossGroup只是处理连接请求，workerGroup是和客户端业务处理
         * 两个都是无线循环
         * bossGroup和workerGroup含有的子线程（NioEventLoop）的个数
         * 默认实际cpu核数*2
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //创建服务端启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)//设置2个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列得到的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接状态
                    //.handler(null)  //bossGroup的处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() { //workerGroup的处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new NettyDecoder())
                                    .addLast(new NettyEncoder())
                                    .addLast(new NettyRequestHandler());
                        }
                    });
            log.info("=====> netty服务器准备中。。。");
            //启动服务器，绑定端口
            ChannelFuture future = bootstrap.bind(nettyServerProperies.getPort()).sync();
            //注册监听器
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()){
                        log.info("=====> netty服务器监听端口{}成功！！！",nettyServerProperies.getPort());
                    }else {
                        log.info("=====> netty服务器监听端口{}失败！！！",nettyServerProperies.getPort());
                    }
                }
            });
            //关闭通道
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
