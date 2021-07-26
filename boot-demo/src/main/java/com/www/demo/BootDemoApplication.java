package com.www.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @Description spring boot启动类
 *  springboot项目代码必须放到SpringBootDemoApplication类同级目录或下级目录
 * @Author www
 * @Date 2021/5/20 23:22
 */
@SpringBootApplication //springboot核心注解，主要用于开启spring自动配置
@MapperScan(basePackages = "com.www.demo.model.mapper")//配置mapper扫描路径。mapper接口类不使用@Mapper时使用该注解
@EnableDubbo //开启dubbo注解
public class BootDemoApplication {
	/*
	 * @Author www
	 * @Date 2021/5/20 23:23
	 * @Description springboot启动方法
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}
}
