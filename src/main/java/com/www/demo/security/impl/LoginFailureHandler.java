package com.www.demo.security.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description security登录认证失败处理
 * @Author www
 * @Date 2021/6/22 23:13
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    private static Logger LOG = LoggerFactory.getLogger(LoginFailureHandler.class);
    /**
     * @Author www
     * @Date 2021/6/22 23:15
     * @Description 登录失败处理事件
     * @param request 请求报文
     * @param response 响应报文
     * @param exception 认证异常
     * @return void
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        LOG.info("-----> security登录认证失败处理");
    }
}
