package com.www.demo.restful.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.common.ResponseMsg;
import com.www.demo.model.common.ResponseEnum;
import com.www.demo.model.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find")
    public @ResponseBody ResponseMsg<List<SysUser>> find(){
        List<SysUser> sysUserList = sysUserService.findUserList(1,null);
        return new ResponseMsg<>(ResponseEnum.SUCCESS, sysUserList);
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseMsg<SysUser> get(@PathVariable("id") String userId){
        SysUser sysUser = sysUserService.selectByUserId(userId);
        return new ResponseMsg<>(ResponseEnum.SUCCESS, sysUser);
    }

    @PostMapping("/post/{id}")
    public @ResponseBody ResponseMsg<SysUser> post(@PathVariable("id") String userId){
        SysUser sysUserDTO = sysUserService.selectByUserId(userId);
        return new ResponseMsg<>(ResponseEnum.SUCCESS, sysUserDTO);
    }
}
