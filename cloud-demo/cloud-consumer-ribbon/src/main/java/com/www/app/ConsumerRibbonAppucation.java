package com.www.app;

import com.www.rule.MyRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>@Description Restful API调用方 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:21 </p>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//配置feign扫描路径
@EnableFeignClients(basePackages = {"com.www.app.feign"})
//配置cloud-provider服务的负载均衡策略
@RibbonClient(name = "cloud-provider",configuration = MyRibbonConfig.class)
public class ConsumerRibbonAppucation {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonAppucation.class,args);
    }
}


