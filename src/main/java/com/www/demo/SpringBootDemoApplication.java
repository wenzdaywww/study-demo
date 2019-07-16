package com.www.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * spring boot启动类
 * EnableCaching  开启缓存配置
 * @author www
 *
 */
@SpringBootApplication
@EnableCaching    
public class SpringBootDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
