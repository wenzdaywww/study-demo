package com.www.demo.qadmin.controller.login;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Description 管理后台登入Controller
 * @Author www
 * @Date 2021/6/6 16:30
 */
@Controller
public class LoginController {
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
    @RequestMapping("/qadmin/login")
    public String login(@RequestParam("user") String userId, @RequestParam("pwd") String password, HttpSession session,Model model){
        SysUserEntity reqUser = new SysUserEntity();
        reqUser.setUserId(userId);
        reqUser.setPassWord(password);
        SysUserDTO userDTO = sysUserService.findUserInfo(reqUser);
        if (userDTO == null) {
            model.addAttribute("info","用户名或密码错误！！！");
            return "/qadmin/login";
        }else {
            session.setAttribute("user",userDTO);
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
        session.setAttribute("user",null);
        return "/qadmin/login";
    }
}
