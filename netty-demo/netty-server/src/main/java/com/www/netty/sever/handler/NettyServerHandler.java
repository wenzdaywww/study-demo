package com.www.netty.sever.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>@Description netty服务端处理类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 16:09 </p>
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * <p>@Description 读取客户端发送的数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 16:54  </p>
     * @param ctx 通道
     * @param msg 数据信息
     * @return void
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        ByteBuf buf =  (ByteBuf)msg;
        log.info("客户端地址："+ channel.remoteAddress() + ", 发送的消息 = " + buf.toString(CharsetUtil.UTF_8));
    }
    /**
     * <p>@Description 数据读取完毕 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 16:55  </p>
     * @param ctx
     * @return void
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("数据读取完毕",CharsetUtil.UTF_8));
    }
    /**
     * <p>@Description 异常处理，关闭通道 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 16:56  </p>
     * @param ctx 通道
     * @param cause 异常
     * @return void
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
