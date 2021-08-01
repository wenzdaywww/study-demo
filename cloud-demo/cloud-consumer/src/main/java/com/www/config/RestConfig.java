package com.www.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
