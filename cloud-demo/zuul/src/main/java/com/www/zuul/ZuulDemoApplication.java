package com.www.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>@Description Zuul服务启动类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/11 21:16 </p>
 */
@SpringBootApplication
@EnableZuulProxy //开启zuul路由网关
public class ZuulDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class,args);
    }
}
