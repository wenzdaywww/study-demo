package com.www.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching    //开启缓存配置
public class SpringBootDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
