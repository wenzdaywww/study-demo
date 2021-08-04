package com.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>@Description Restful API提供方 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:23 </p>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RestProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProviderApplication.class,args);
    }
}
