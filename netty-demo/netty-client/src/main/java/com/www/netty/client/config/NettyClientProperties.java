package com.www.netty.client.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>@Description netty客户端配置属性 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/24 10:08 </p>
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "com.www.netty.client")
public class NettyClientProperties {
    /** netty服务端ip **/
    private String serverIp;
    /** netty服务端端口 **/
    private int port;
    /** 序列化类型 **/
    private String serial;
}
