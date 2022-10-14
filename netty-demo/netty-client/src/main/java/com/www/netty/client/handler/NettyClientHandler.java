package com.www.netty.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@Description netty客户端处理类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 16:28 </p>
 */
@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * <p>@Description 通道准备就绪，发送信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:00  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello word", CharsetUtil.UTF_8));
    }
    /**
     * <p>@Description 读取服务端回复的数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 16:54  </p>
     * @param ctx 通道
     * @param msg 数据信息
     * @return void
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        log.info("服务器地址："+ ctx.channel().remoteAddress() + ",收到的消息="+ buf.toString(CharsetUtil.UTF_8));
    }
    /**
     * <p>@Description 异常处理，关闭通道 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:01  </p>
     * @param ctx 通道
     * @param cause 异常
     * @return void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
