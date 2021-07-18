package com.www.demo.restful.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Description RESTful设计风格测试代码控制层
 * @Author www
 * @Date 2021/5/25 22:56
 */
@Controller
@RequestMapping("/rest")
public class RESTfulController {
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/get/{id}")
    public @ResponseBody
    SysUser get(@PathVariable("id") String userId){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        return sysUserDTO;
    }

    @PostMapping("/post/{id}")
    public @ResponseBody
    SysUser post(@PathVariable("id") String userId){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        return sysUserDTO;
    }
}
