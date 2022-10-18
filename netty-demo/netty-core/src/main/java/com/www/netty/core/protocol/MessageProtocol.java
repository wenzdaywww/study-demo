package com.www.netty.core.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>@Description 消息协议结构 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 14:41 </p>
 */
@Data
public class MessageProtocol<T> implements Serializable {
    /** 消息头 **/
    private MessageHeader header;
    /** 消息体 **/
    private T body;
}
