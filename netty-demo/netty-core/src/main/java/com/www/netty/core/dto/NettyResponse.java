package com.www.netty.core.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>@Description netty响应数据类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:42 </p>
 */
@Data
public class NettyResponse implements Serializable {
    /** 响应结果 **/
    private Object data;
    /** 响应信息 **/
    private String msg;
}
