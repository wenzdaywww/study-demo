package com.www.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * spring boot启动类
 * springboot项目代码必须放到SpringBootDemoApplication类同级目录或下级目录
 * @author www
 *
 */
@SpringBootApplication //springboot核心注解，主要用于开启spring自动配置
public class SpringBootDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
