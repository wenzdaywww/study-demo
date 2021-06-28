package com.www.demo.qadmin.controller.login;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Description 管理后台登入Controller层
 * @Author www
 * @Date 2021/6/6 16:30
 */
@Controller
public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @Author www
     * @Date 2021/6/6 16:34
     * @Description 进入登入页面
     *
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("/qadmin")
    public String index(){
        LOG.info("-----> qadmin登录页面");
        return "/quickadmin/login";
    }
    /**
     * @Author www
     * @Date 2021/6/6 23:15
     * @Description 退出登录
     * @param session
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/logout")
    public String logout(HttpSession session){
        LOG.info("-----> qadmin注销");
        session.setAttribute("adminUser",null);
        return "/quickadmin/login";
    }
}
