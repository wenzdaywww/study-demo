package com.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author www
 * @version 1.0
 * @description Restful API调用配置
 * @date 2021/8/1 18:58
 */
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
