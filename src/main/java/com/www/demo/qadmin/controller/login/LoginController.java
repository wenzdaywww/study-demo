package com.www.demo.qadmin.controller.login;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/qadmin")
    public ModelAndView index(){
        LOG.info("-----> qadmin登录页面");
        return new ModelAndView("/qadmin/login");
    }
    /**
     * @author www
     * @date 2021/6/6 16:55
     * @description 登入
     * @deprecated 在使用spring security管理登录认证后，该方法就不能使用
     * @param userId 用户ID
     * @param password 用户密码
     * @return org.springframework.web.servlet.ModelAndView
     */
    @PostMapping("/qadmin/login")
    public String login(@RequestParam("user") String userId, @RequestParam("pwd") String password, HttpSession session,Model model){
        LOG.info("-----> qadmin登录");
        SysUserEntity reqUser = new SysUserEntity();
        reqUser.setUserId(userId);
        reqUser.setPassWord(password);
        SysUserEntity userEntity = sysUserService.findUserAllInfo(reqUser);
        if (userEntity == null) {
            model.addAttribute("info","用户名或密码错误！！！");
            return "/qadmin/login";
        }else {
            session.setAttribute("adminUser",userEntity);
            return "redirect:/qadmin/main";
        }
    }
    /**
     * @Author www
     * @Date 2021/6/6 23:15
     * @Description 退出登录
     *
     * @param session
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/logout")
    public String logout(HttpSession session){
        LOG.info("-----> qadmin注销");
        session.setAttribute("adminUser",null);
        return "/qadmin/login";
    }
}
