package com.www.demo.qadmin.controller.login;

import com.www.demo.app.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <p>@Description 管理后台登入Controller层 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:03 </p>
 */
@Controller
public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * <p>@Description 进入登入页面 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:03 </p>
     * @return java.lang.String
     */
    @GetMapping("/qadmin")
    public String index(){
        LOG.info("-----> qadmin登录页面");
        return "quickadmin/login";
    }
    /**
     * <p>@Description 退出登录 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:03 </p>
     * @param session 会话
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/logout")
    public String logout(HttpSession session){
        LOG.info("-----> qadmin注销");
        session.setAttribute("adminUser",null);
        return "quickadmin/login";
    }
}
