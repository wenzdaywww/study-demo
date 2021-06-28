package com.www.demo.security.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description security登录认证成功处理
 * @Author www
 * @Date 2021/6/22 23:13
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private static Logger LOG = LoggerFactory.getLogger(LoginSuccessHandler.class);
    /**
     * @Author www
     * @Date 2021/6/22 23:37
     * @Description security登录认证成功处理
     * @param request 请求报文
     * @param response 响应报文
     * @param authentication 身份验证
     * @return void
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LOG.info("-----> security登录认证成功处理");
        new DefaultRedirectStrategy().sendRedirect(request,response,"/qadmin/main");
    }
}
