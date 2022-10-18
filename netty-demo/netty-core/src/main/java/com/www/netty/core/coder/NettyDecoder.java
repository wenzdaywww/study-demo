package com.www.netty.core.coder;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;
import com.www.netty.core.serialize.JsonSerialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * <p>@Description netty解码器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 14:36 </p>
 */
public class NettyDecoder extends ByteToMessageDecoder{
    /** 序列化对象 **/
    private JsonSerialization jsonSerialization = new JsonSerialization();
    /**
     * <p>@Description 消息解码 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/18 14:48  </p>
     * @param ctx
     * @param byteBuf
     * @param list
     * @return void
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        MessageProtocol protocol = new MessageProtocol();
        byte[] data = new byte[byteBuf.readInt()];

        MessageHeader header = new MessageHeader();
        header.setLen(data.length);
        protocol.setHeader(header);

        byteBuf.readBytes(data);
        NettyRequest request = jsonSerialization.deserialize(data,NettyRequest.class);
        protocol.setBody(request);
        list.add(protocol);
    }
}
