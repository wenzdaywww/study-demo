package com.www.netty.client.config;

import com.www.netty.client.core.INettyClient;
import com.www.netty.client.core.NettyClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description netty客户端配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 16:22 </p>
 */
@Slf4j
@Configuration
public class NettyClientConfiguration {
    /**
     * <p>@Description 构建一个netty客户端 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/17 17:07  </p>
     * @return com.www.netty.client.core.NettyClient
     */
    @Bean
    public INettyClient nettyClient(){
        return new NettyClient();
    }
}
