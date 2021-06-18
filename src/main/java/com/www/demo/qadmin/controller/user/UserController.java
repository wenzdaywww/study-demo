package com.www.demo.qadmin.controller.user;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
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
        List<SysUserEntity> list = sysUserService.findUserList(null);
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
        SysUserEntity sysUserEntity = sysUserService.selectByPrimaryKey(userId);
        if (sysUserEntity == null){
            sysUserEntity = new SysUserEntity();
            sysUserEntity.setUserId(userId);
            sysUserEntity.setUserName(userName);
            sysUserEntity.setPassWord(password);
            sysUserEntity.setIsDelete("0");
            sysUserEntity.setSysCreateDate(new Date());
            sysUserEntity.setSysUpdateDate(new Date());
            sysUserService.insertSelective(sysUserEntity);
        }else {
            sysUserEntity.setUserName(userName);
            sysUserEntity.setPassWord(password);
            sysUserEntity.setSysUpdateDate(new Date());
            sysUserService.updateByPrimaryKeySelective(sysUserEntity);
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
        SysUserEntity sysUserEntity = sysUserService.selectByPrimaryKey(userId);
        if (sysUserEntity != null){
            sysUserEntity.setIsDelete(StringUtils.equals("1", sysUserEntity.getIsDelete()) ? "0" : "1");
            sysUserService.updateByPrimaryKeySelective(sysUserEntity);
        }
        return findUserList(model);
    }
}
