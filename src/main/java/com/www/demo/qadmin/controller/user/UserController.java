package com.www.demo.qadmin.controller.user;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Description
 * @Author www
 * @Date 2021/6/7 22:52
 */
@Controller
public class UserController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * @Author www
     * @Date 2021/6/7 23:00
     * @Description 查询用户列表
     *
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/userList")
    public String findUserList(Model model){
        List<SysUser> list = sysUserService.findUserList(null);
        model.addAttribute("userList",list);
        return "/qadmin/user_index";
    }
    /**
     * @Author www
     * @Date 2021/6/7 23:00
     * @Description 跳转添加用户页面
     *
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/addUser")
    public String addUser(Model model){
        return "/qadmin/user_add";
    }
    /**
     * @Author www
     * @Date 2021/6/8 00:00
     * @Description 添加用户
     *
     * @param userId 用户ID
     * @param userName 用户名
     * @param password 用户密码
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("/qadmin/createUser")
    public String createUser(@RequestParam("id")String userId,@RequestParam("name")String userName,@RequestParam("password")String password,Model model){
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setUserName(userName);
        sysUser.setPassWord(password);
        sysUser.setSysCreateDate(new Date());
        sysUser.setSysUpdateDate(new Date());
        sysUserService.insertSelective(sysUser);
        return findUserList(model);
    }
}
