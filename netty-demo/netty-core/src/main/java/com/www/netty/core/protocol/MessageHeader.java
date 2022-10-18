package com.www.netty.core.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>@Description 消息头数据结构 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 16:54 </p>
 */
@Data
public class MessageHeader implements Serializable {
    /** 数据长度 **/
    private int len;
}
