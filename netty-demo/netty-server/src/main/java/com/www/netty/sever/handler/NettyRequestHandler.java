package com.www.netty.sever.handler;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.protocol.MessageProtocol;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@Description netty响应数据处理器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:41 </p>
 */
@Slf4j
public class NettyRequestHandler extends SimpleChannelInboundHandler<MessageProtocol<NettyRequest>> {
    /**
     * <p>@Description 客户端连接添加 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("添加客户端{}" , channel.remoteAddress());
    }
    /**
     * <p>@Description 客户端连接激活处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:02  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("连接客户端{}" , channel.remoteAddress());
    }
    /**
     * <p>@Description 读取客户端发送的消息处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @param protocol
     * @return void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol<NettyRequest> protocol) throws Exception {
        Channel channel = ctx.channel();
        log.info("收到客户端的消息：{}" , protocol.getBody().getMsg());
        channel.writeAndFlush(protocol);
    }
    /**
     * <p>@Description 客户端连接断开处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 11:04  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("断开客户端{}" , channel.remoteAddress());
    }
}
