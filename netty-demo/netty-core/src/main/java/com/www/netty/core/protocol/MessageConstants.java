package com.www.netty.core.protocol;

/**
 * <p>@Description 消息协议常量 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 11:09 </p>
 */
public class MessageConstants {
    /** 协议头字节长度 **/
    public static final int HEADER_LENGTH = 42;
    /** 协议头魔数值 **/
    public static final short MAGIC = 3;
    /** 协议头版本号 **/
    public static final byte VERSION = 1;
    /** 协议头请求ID长度 **/
    public static final int REQID_LENGTH = 32;
}
