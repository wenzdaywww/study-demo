package com.www.netty.core.coder;

import com.www.netty.core.dto.NettyRequest;
import com.www.netty.core.dto.NettyResponse;
import com.www.netty.core.protocol.MessageConstants;
import com.www.netty.core.protocol.MessageEnum;
import com.www.netty.core.protocol.MessageHeader;
import com.www.netty.core.protocol.MessageProtocol;
import com.www.netty.core.serialize.INettySerialization;
import com.www.netty.core.serialize.SerializationFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * <p>@Description netty解码器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 14:36 </p>
 */
public class NettyDecoder extends ByteToMessageDecoder{
    /** 序列化对象 **/
    private INettySerialization nettySerialization;
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
        //判断字节总长度是否小于协议头长度
        if (byteBuf.readableBytes() < MessageConstants.HEADER_LENGTH){
            return;
        }
        MessageHeader header = new MessageHeader();
        //魔数
        short magic = byteBuf.readShort();
        if (magic != MessageConstants.MAGIC){
            throw new IllegalArgumentException("magic="+ magic +"数值错误。");
        }
        //协议版本号
        byte version = byteBuf.readByte();
        //序列化算法
        byte serialization = byteBuf.readByte();
        //报文类型
        byte msgType = byteBuf.readByte();
        //状态
        byte status = byteBuf.readByte();
        //消息ID
        CharSequence charSequence = byteBuf.readCharSequence(MessageConstants.REQID_LENGTH, Charset.forName("UTF-8"));
        String requestId = charSequence.toString();
        //数据长度
        int msgLen = byteBuf.readInt();
        //组装消息协议头
        header.setMagic(magic);
        header.setVersion(version);
        header.setSerialization(serialization);
        header.setMsgType(msgType);
        header.setStatus(status);
        header.setRequestId(requestId);
        header.setMsgLen(msgLen);
        MessageProtocol protocol = new MessageProtocol<>();
        protocol.setHeader(header);
        //数据内容
        byte[] data = new byte[msgLen];
        byteBuf.readBytes(data);
        nettySerialization = SerializationFactory.getInstance(MessageEnum.SERIALIZATION_JDK);
        if (msgType == MessageEnum.TYPE_REQ.getCode()){
            NettyRequest request = nettySerialization.deserialize(data);
            protocol.setBody(request);
        }else {
            NettyResponse response = nettySerialization.deserialize(data);
            protocol.setBody(response);
        }
        list.add(protocol);
    }
}
