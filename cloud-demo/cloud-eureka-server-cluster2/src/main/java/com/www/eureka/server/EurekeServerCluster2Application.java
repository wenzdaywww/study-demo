package com.www.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>@Description eureka注册中心服务启动类型 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/2 23:09 </p>
 */
@SpringBootApplication
@EnableEurekaServer //开启eureka注册中心服务
public class EurekeServerCluster2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekeServerCluster2Application.class,args);
    }
}
