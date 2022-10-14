package com.www.netty.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>@Description netty客户端启动类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 17:24 </p>
 */
@SpringBootApplication
public class NettyClientApplication {
    /**
     * <p>@Description 启动方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:25  </p>
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class,args);
    }
}
