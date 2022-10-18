package com.www.netty.core.coder;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.protocol.MessageProtocol;
import com.www.netty.core.serialize.JsonSerialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * <p>@Description netty编码器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 14:36 </p>
 */
public class NettyEncoder extends MessageToByteEncoder<MessageProtocol<NettyRequest>> {
    /** 序列化对象 **/
    private JsonSerialization jsonSerialization = new JsonSerialization();
    /**
     * <p>@Description 消息编码 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 14:42  </p>
     * @param ctx
     * @param messageProtocol
     * @param byteBuf
     * @return void
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol messageProtocol, ByteBuf byteBuf) throws Exception {
        byte[] data = jsonSerialization.serialize(messageProtocol.getBody());
        byteBuf.writeInt(data.length);
        byteBuf.writeBytes(data);
    }
}
