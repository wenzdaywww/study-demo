package com.www.demo.qadmin.controller.login;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;

/**
 * @version 1.0
 * @Description 管理后台登入Controller
 * @Author www
 * @Date 2021/6/6 16:30
 */
@Controller
@RequestMapping("/")
public class QAdminLoginController {
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @Author www
     * @Date 2021/6/6 16:34
     * @Description 进入登入页面
     *
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/qadmin/login");
    }
    /**
     * @Author www
     * @Date 2021/6/6 16:55
     * @Description 登入
     *
     * @param userId 用户ID
     * @param password 用户密码
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/login/{userId}/{password}")
    public ModelAndView login(@PathVariable("userId") String userId,@PathVariable("password") String password){
        SysUser reqUser = new SysUser();
        reqUser.setUserId(userId);
        reqUser.setPassWord(password);
        SysUser user = sysUserService.selective(reqUser);
        if (user==null) {
            ModelAndView modelAndView = new ModelAndView("/qadmin/login");
            modelAndView.addObject("info","用户名或密码错误！！！");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/qadmin/index");
            modelAndView.addObject("userId",user.getUserId());
            modelAndView.addObject("userName",user.getUserName());
            return modelAndView;
        }
    }
}
