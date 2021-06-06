package com.www.demo.qadmin.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Description 登录拦截器
 * @Author www
 * @Date 2021/6/6 21:47
 */
public class QAdminLoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * @Author www
     * @Date 2021/6/6 21:51
     * @Description 登录拦截处理
     *
     * @param request 请求参数
     * @param response 响应参数
     * @param handler
     * @return boolean ture不拦截，false拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
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
