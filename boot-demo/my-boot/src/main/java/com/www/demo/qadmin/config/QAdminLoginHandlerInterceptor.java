package com.www.demo.qadmin.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>@Description 登录拦截器，用于自定义Spring MVC的拦截器 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:02 </p>
 */
public class QAdminLoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * <p>@Description 登录拦截处理 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:02 </p>
     * @param request 请求参数
     * @param response 响应参数
     * @param handler 处理器
     * @return boolean ture不拦截，false拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("adminUser");
        if (user == null){
            request.setAttribute("info","没有权限，请先登录！");
            System.out.println("-------没有权限，请先登录！-------");
            request.getRequestDispatcher("/qadmin").forward(request,response);
            return false;
        }else {
            System.out.println("-------已经登录！-------");
            return true;
        }
    }
}
