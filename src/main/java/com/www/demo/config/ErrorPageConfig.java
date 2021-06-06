package com.www.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @version 1.0
 * @Description 错误信息页面配置
 * @Author www
 * @Date 2021/6/6 23:34
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    /**
     * @Author www
     * @Date 2021/6/6 23:34
     * @Description 错误信息页面配置
     *
     * @param registry
     * @return void
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        /*1、按错误的类型显示错误的网页*/
        /*错误类型为404，找不到网页的，默认显示404.html网页*/
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
        /*错误类型为500，表示服务器响应错误，默认显示500.html网页*/
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
        registry.addErrorPages(e404, e500);
    }
}
