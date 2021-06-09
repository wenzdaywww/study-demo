package com.www.demo.qadmin.controller.user;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/qadmin/userList")
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
    @GetMapping("/qadmin/addUser")
    public String toAddUserPage(Model model){
        return "/qadmin/user_add";
    }
    /**
     * @Author www
     * @Date 2021/6/8 00:00
     * @Description 保存用户
     *
     * @param userId 用户ID
     * @param userName 用户名
     * @param password 用户密码
     * @param model
     * @return java.lang.String
     */
    @PostMapping("/qadmin/addUser")
    @Transactional(rollbackForClassName = "Exception")
    public String saveUser(@RequestParam("id")String userId, @RequestParam("name")String userName, @RequestParam("password")String password, Model model){
        SysUser sysUser = sysUserService.selectByPrimaryKey(userId);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setUserId(userId);
            sysUser.setUserName(userName);
            sysUser.setPassWord(password);
            sysUser.setIsDelete("0");
            sysUser.setSysCreateDate(new Date());
            sysUser.setSysUpdateDate(new Date());
            sysUserService.insertSelective(sysUser);
        }else {
            sysUser.setUserName(userName);
            sysUser.setPassWord(password);
            sysUser.setSysUpdateDate(new Date());
            sysUserService.updateByPrimaryKeySelective(sysUser);
        }
        return findUserList(model);
    }
    /**
     * @Author www
     * @Date 2021/6/8 23:03
     * @Description 删除用户
     *
     * @param userId 用户ID
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/qadmin/deleteUser/{id}")
    @Transactional(rollbackForClassName = "Exception")
    public String deleteUser(@PathVariable("id")String userId, Model model){
        SysUser sysUser = sysUserService.selectByPrimaryKey(userId);
        if (sysUser != null){
            sysUser.setIsDelete(StringUtils.equals("1",sysUser.getIsDelete()) ? "0" : "1");
            sysUserService.updateByPrimaryKeySelective(sysUser);
        }
        return findUserList(model);
    }
}
