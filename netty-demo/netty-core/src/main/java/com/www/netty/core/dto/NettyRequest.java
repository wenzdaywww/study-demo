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
    /** 请求的服务名称 **/
    private String serviceName;
    /** 请求的服务版本 **/
    private String version;
    /** 请求的服务方法 **/
    private String method;
    /** 请求的服务方法参数类型 **/
    private Class<?>[] paramType;
    /** 请求的服务方法参数值 **/
    private Object[] param;
}
