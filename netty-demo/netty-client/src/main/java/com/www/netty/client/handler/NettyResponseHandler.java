package com.www.netty.client.handler;

import com.www.netty.client.store.RpcResponseCache;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageProtocol;
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
public class NettyResponseHandler extends SimpleChannelInboundHandler<MessageProtocol<NettyResponse>> {
    /**
     * <p>@Description 接收服务端消息 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 15:18  </p>
     * @param ctx
     * @param protocol
     * @return void
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol<NettyResponse> protocol) throws Exception {
        log.info("=====> 客户端收到的数据：{}",protocol);
        //将返回结果保存到异步对象中
        RpcResponseCache.setResponse(protocol.getHeader().getRequestId(),protocol);
    }
}
