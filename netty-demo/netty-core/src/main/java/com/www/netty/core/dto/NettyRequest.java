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
public class NettyRequest implements Serializable {

    private String name;
    /** 请求数据 **/
    private String msg;
}
