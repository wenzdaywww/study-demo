package com.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>@Description Restful API调用方 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:21 </p>
 */
@SpringBootApplication
@EnableEurekaClient
public class RestConsumerAppucation {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerAppucation.class,args);
    }
}
