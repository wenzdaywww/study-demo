package com.www.netty.core.coder;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.protocol.MessageEnum;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;
import com.www.netty.core.serialize.INettySerialization;
import com.www.netty.core.serialize.SerializationFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * <p>@Description netty编码器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 14:36 </p>
 */
public class NettyEncoder extends MessageToByteEncoder<MessageProtocol<NettyRequest>> {
    /** 序列化对象 **/
    private INettySerialization nettySerialization;
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
        MessageHeader header = messageProtocol.getHeader();
        //魔数
        byteBuf.writeShort(header.getMagic());
        //协议版本号
        byteBuf.writeByte(header.getVersion());
        //序列化算法
        byteBuf.writeByte(header.getSerialization());
        //报文类型
        byteBuf.writeByte(header.getMsgType());
        //状态
        byteBuf.writeByte(header.getStatus());
        //消息ID
        byteBuf.writeCharSequence(header.getRequestId(), Charset.forName("UTF-8"));
        //数据长度
        nettySerialization = SerializationFactory.getInstance(MessageEnum.SERIALIZATION_JDK);
        byte[] data = nettySerialization.serialize(messageProtocol.getBody());
        byteBuf.writeInt(data.length);
        //数据内容
        byteBuf.writeBytes(data);
    }
}
