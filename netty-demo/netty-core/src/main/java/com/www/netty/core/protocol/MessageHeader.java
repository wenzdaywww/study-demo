package com.www.netty.core.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>@Description 消息头数据结构
 *     +---------------------------------------------------------------+
 *     | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
 *     +---------------------------------------------------------------+
 *     | 状态 1byte |        消息 ID 32byte     |      数据长度 4byte     |
 *     +---------------------------------------------------------------+
 * </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 16:54 </p>
 */
@Data
public class MessageHeader implements Serializable {
    /**
     *  魔数: 是通信双方协商的一个暗号，通常采用固定的几个字节表示。魔数的作用是防止任何人随便向服务器的端口上发送数据。 例如 java Class 文件开头就存储了魔数 0xCAFEBABE，在加载 Class 文件时首先会验证魔数的正确性
     */
    private short magic;

    /**
     *  协议版本号: 随着业务需求的变化，协议可能需要对结构或字段进行改动，不同版本的协议对应的解析方法也是不同的。
     */
    private byte version;

    /**
     *  序列化算法: 序列化算法字段表示数据发送方应该采用何种方法将请求的对象转化为二进制，以及如何再将二进制转化为对象，如 JSON、Hessian、Java 自带序列化等。
     */
    private byte serialization;

    /**
     *  报文类型:  在不同的业务场景中，报文可能存在不同的类型。RPC 框架中有请求、响应、心跳等类型的报文。
     */
    private byte msgType;

    /**
     *  状态:  状态字段用于标识请求是否正常（SUCCESS、FAIL）。
     */
    private byte status;

    /**
     *  消息ID: 请求唯一ID，通过这个请求ID将响应关联起来，也可以通过请求ID做链路追踪。
     */
    private String requestId;

    /**
     *  数据长度:  标明数据的长度，用于判断是否是一个完整的数据包
     */
    private int msgLen;
    /**
     * <p>@Description 构建header数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 14:21  </p>
     * @return com.www.netty.core.protocol.MessageHeader
     */
    public static MessageHeader build(){
        MessageHeader header = new MessageHeader();
        header.setMagic(MessageConstants.MAGIC);
        header.setVersion(MessageConstants.VERSION);
        header.setSerialization(MessageEnum.SERIALIZATION_JDK.getCode());
        header.setStatus(MessageEnum.STATUS_SUC.getCode());
        return header;
    }
}
