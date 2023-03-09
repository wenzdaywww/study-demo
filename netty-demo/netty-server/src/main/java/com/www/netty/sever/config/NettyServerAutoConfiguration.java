package com.www.netty.sever.config;

import com.www.netty.sever.core.NettyServer;
import com.www.netty.sever.core.RpcServerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description netty服务端自动配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 15:56 </p>
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(value = NettyServerProperies.class)
public class NettyServerAutoConfiguration {
    /**
     * <p>@Description 构建一个netty服务端 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/17 17:08  </p>
     * @return com.www.netty.sever.core.NettyServer
     */
    @Bean
    @ConditionalOnMissingBean
    public NettyServer nettyServer(@Autowired NettyServerProperies nettyServerProperies){
        return new NettyServer(nettyServerProperies);
    }
    /**
     * <p>@Description RPC服务提供方处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/21 15:44  </p>
     * @return com.www.netty.sever.core.RpcServerProvider
     */
    @Bean
    public RpcServerProvider rpcServerProvider(){
        return new RpcServerProvider();
    }
}
