package com.www.demo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author www
 * @version 1.0
 * @description swagger配置类
 * swagger页面访问路径：localhost:8080/swagger-ui.html
 * @date 2021/6/24 23:19
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * @author www
     * @date 2021/6/27 11:05
     * @description 配置qadmin的docket对象信息
     * @param env 环境配置信息
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket qadminDocket(Environment env){
        //获取环境配置,判断是否开启swagger
        Profiles profiles = Profiles.of("test","dev");
        boolean envFlag = env.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("qadmin")
                //配置是否启动swagger
                .enable(envFlag)
                .apiInfo(getApiInfo())//配置API信息
                //配置要扫描的接口方式
                .select().apis(RequestHandlerSelectors.basePackage("com.www.demo"))
                //配置过滤的路径
                .paths(PathSelectors.ant("/qadmin/**"))
                .build();
    }
    /**
     * @author www
     * @date 2021/6/27 11:05
     * @description 配置websocket的docket对象信息
     * @param env 环境配置信息
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket restFulDocket(Environment env){
        //获取环境配置,判断是否开启swagger
        Profiles profiles = Profiles.of("test","dev");
        boolean envFlag = env.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RESTful")
                //配置是否启动swagger
                .enable(envFlag)
                .apiInfo(getApiInfo())//配置API信息
                //配置要扫描的接口方式
                .select().apis(RequestHandlerSelectors.basePackage("com.www.demo"))
                //配置过滤的路径
                .paths(PathSelectors.ant("/rest/**"))
                .build();
    }
    /**
     * @author www
     * @date 2021/6/27 11:06
     * @description 配置API信息
     * @return springfox.documentation.service.ApiInfo
     */
    private ApiInfo getApiInfo(){
        Contact contact = new Contact("www","https://github.com/wenzdaywww","123456789@qq.com");
        return new ApiInfo("swagger配置","随便测试的","v1.0",
                "www.baidu.com",contact,"https://github.com/wenzdaywww",
                "www.baidu.com",new ArrayList<>());
    }
}
