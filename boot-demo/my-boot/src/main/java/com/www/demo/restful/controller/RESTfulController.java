package com.www.demo.restful.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.common.ResponseDTO;
import com.www.demo.model.common.ResponseEnum;
import com.www.demo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>@Description RESTful设计风格测试代码控制层 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:10 </p>
 */
@Controller
@RequestMapping("/rest")
public class RESTfulController {
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/find")
    public @ResponseBody ResponseDTO<List<SysUser>> find(){
        List<SysUser> sysUserList = sysUserService.findUserList(1,null);
        return new ResponseDTO<>(ResponseEnum.SUCCESS, sysUserList);
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseDTO<SysUser> get(@PathVariable("id") String userId){
        SysUser sysUser = sysUserService.selectByUserId(userId);
        return new ResponseDTO<>(ResponseEnum.SUCCESS, sysUser);
    }

    @PostMapping("/post/{id}")
    public @ResponseBody ResponseDTO<SysUser> post(@PathVariable("id") String userId){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        return new ResponseDTO<>(ResponseEnum.SUCCESS, sysUserDTO);
    }
}
