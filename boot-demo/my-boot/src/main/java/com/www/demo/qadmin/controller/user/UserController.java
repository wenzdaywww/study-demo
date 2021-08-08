package com.www.demo.qadmin.controller.user;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>@Description 管理后台用户信息Controller层 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:04 </p>
 */
@Controller
public class UserController {
    @Autowired
    private ISysUserService sysUserService;
    /**
     * <p>@Description 查询用户列表 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:04 </p>
     * @param page 当前页数
     * @param model model
     * @return java.lang.String
     */
    @GetMapping("/qadmin/userList")
    public String findUserList(@RequestParam("page") int page, Model model){
        List<SysUser> list = sysUserService.findUserList(page,null);
        model.addAttribute("userList",list);
        return "quickadmin/user_index";
    }
    /**
     * <p>@Description 跳转添加用户页面 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:04 </p>
     * @param model model
     * @return java.lang.String
     */
    @GetMapping("/qadmin/addUser")
    public String toAddUserPage(Model model){
        return "quickadmin/user_add";
    }
    /**
     * <p>@Description 保存用户 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:04 </p>
     * @param userId 用户ID
     * @param userName 用户名
     * @param password 用户密码
     * @param model model
     * @return java.lang.String
     */
    @PostMapping("/qadmin/addUser")
    public String saveUser(@RequestParam("id")String userId, @RequestParam("name")String userName, @RequestParam("password")String password, Model model){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        if (sysUserDTO == null){
            sysUserDTO = new SysUser();
            sysUserDTO.setUserId(userId);
            sysUserDTO.setUserName(userName);
            sysUserDTO.setPassWord(password);
            sysUserDTO.setIsDelete("0");
            sysUserDTO.setSysCreateDate(new Date());
            sysUserDTO.setSysUpdateDate(new Date());
            sysUserService.insertSelective(sysUserDTO);
        }else {
            sysUserDTO.setUserName(userName);
            sysUserDTO.setPassWord(password);
            sysUserDTO.setSysUpdateDate(new Date());
            sysUserService.updateByUserId(sysUserDTO);
        }
        return findUserList(1,model);
    }
    /**
     * <p>@Description 删除用户 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:05 </p>
     * @param userId 用户ID
     * @param model model
     * @return java.lang.String
     */
    @GetMapping("/qadmin/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")String userId, Model model){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        if (sysUserDTO != null){
            sysUserDTO.setIsDelete(StringUtils.equals("1", sysUserDTO.getIsDelete()) ? "0" : "1");
            sysUserService.updateByUserId(sysUserDTO);
        }
        return findUserList(1,model);
    }
}
