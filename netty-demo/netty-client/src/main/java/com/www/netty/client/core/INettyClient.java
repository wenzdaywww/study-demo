package com.www.netty.client.core;

/**
 * <p>@Description netty客户端接口类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/17 17:17 </p>
 */
public interface INettyClient {
    /**
     * <p>@Description 发送请求 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/17 17:17  </p>
     * @param ip 请求ip
     * @param port 请求端口
     * @param msg 请求内容
     * @return java.lang.Object 响应内容
     */
    Object sendRequest(String ip,int port,String msg);
}
