package com.www.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description Zuul配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/11 22:36 </p>
 */
@Configuration
public class ZuulConfig {
    /**
     * <p>@Description 自定义zuul过滤器 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/11 22:56 </p>
     * @return com.www.zuul.config.IpFilter
     */
//    @Bean
    public IpFilter ipFilter(){
        return new IpFilter();
    }
}
