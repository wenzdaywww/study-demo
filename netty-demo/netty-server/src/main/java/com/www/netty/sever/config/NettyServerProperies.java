package com.www.netty.sever.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>@Description  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/18 11:37 </p>
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "com.www.netty-server")
public class NettyServerProperies {
    /** 服务端端口 **/
    private int port;
}
