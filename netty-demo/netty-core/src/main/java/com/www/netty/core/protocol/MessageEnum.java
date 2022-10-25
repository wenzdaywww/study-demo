package com.www.netty.core.protocol;

/**
 * <p>@Description 消息协议枚举值 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/21 11:16 </p>
 */
public enum MessageEnum {
    /** 报文类型：请求报文 **/
    TYPE_REQ((byte)1),
    /** 报文类型：响应报文 **/
    TYPE_RSP((byte)0),
    /** 报文状态：成功 **/
    STATUS_SUC((byte)1),
    /** 报文状态：失败 **/
    STATUS_FAIL((byte)0);

    /** 枚举值 **/
    private byte code;

    MessageEnum(byte data){
        this.code = data;
    }
    /**
     * <p>@Description 获取枚举值 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 11:22  </p>
     * @return byte
     */
    public byte getCode(){
        return code;
    }
}
