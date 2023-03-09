package com.www.rpc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>@Description netty服务端启动类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/10/14 17:07 </p>
 */
@SpringBootApplication
public class RpcProviderApplication {
    /**
     * <p>@Description 启动方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/10/14 17:08  </p>
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        SpringApplication.run(RpcProviderApplication.class,args);
    }
}
