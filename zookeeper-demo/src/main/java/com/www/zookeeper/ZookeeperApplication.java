package com.www.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <p>@Description zookeeper启动类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2022/3/8 19:44 </p>
 */
@SpringBootApplication
public class ZookeeperApplication {
    /**
     * <p>@Description 启动方法 </p>
     * <p>@Author www </p>
     * <p>@Date 2022/3/8 19:40 </p>
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }

}
