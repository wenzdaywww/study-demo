package com.www.netty.client.config;

import com.www.netty.client.core.INettyClient;
import com.www.netty.client.core.impl.NettyClient;
import com.www.netty.client.processor.RpcClientProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @return com.www.netty.client.core.impl.NettyClient
     */
    @Bean
    public INettyClient nettyClient(){
        return new NettyClient();
    }
    /**
     * <p>@Description 注册bean实例化前处理对象 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:56  </p>
     * @return com.www.netty.client.processor.RpcClientProcessor
     */
    @Bean
    public RpcClientProcessor rpcClientProcessor(@Autowired INettyClient nettyClient){
        return new RpcClientProcessor(nettyClient);
    }
}
