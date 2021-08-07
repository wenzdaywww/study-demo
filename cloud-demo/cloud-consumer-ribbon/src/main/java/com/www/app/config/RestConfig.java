package com.www.app.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>@Description Restful API调用配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:20 </p>
 */
@Configuration
public class RestConfig {
    /**
     * <p>@Description 注入RestTemplate </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:20 </p>
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced //此注解开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    /**
     * <p>@Description 添加全局负载均衡策略 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/7 15:04 </p>
     * @return com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
