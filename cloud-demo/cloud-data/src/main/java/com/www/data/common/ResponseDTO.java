package com.www.data.common;

import java.io.Serializable;

/**
 * <p>@Description 响应报文类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:21 </p>
 */
public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 响应码 **/
    private Integer code;
    /** 响应消息 **/
    private String msg;
    /** 响应数据 **/
    private T data;
    /**
     * <p>@Description 有其他有参构造方法，则必须有无参数的构造方法，否则反序列的时候会报错 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:21 </p>
     */
    public ResponseDTO() {}
    /**
     * <p>@Description 响应报文构造方法(默认成功状态) </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:22 </p>
     * @param data 数据
     */
    public ResponseDTO(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
        this.data = data;
    }
    /**
     * <p>@Description 响应报文构造方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:22 </p>
     * @param code 响应码
     * @param data 数据
     */
    public ResponseDTO(ResponseEnum code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }
    /**
     * <p>@Description 响应报文构造方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:22 </p>
     * @param code 响应码
     * @param msg 响应信息
     * @param data 数据
     */
    public ResponseDTO(ResponseEnum code, String msg, T data) {
        this.code = code.getCode();
        this.msg = msg == null ? code.getMsg() : msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
