package com.www.demo.swagger.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @description 集成Swagger的controller测试类
 * @author www
 * @date 2021/6/24 22:56
 */
@Controller
@RequestMapping("/swag")
public class Swagger2Controller {
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @author www
     * @date 2021/6/18 23:38
     * @description 根据用户ID查询用户信息
     * @param id 用户id
     * @return java.lang.Object
     */
    @GetMapping("/find/{id}")
    public @ResponseBody Object index(@PathVariable("id") String id) {
        SysUserEntity reqUser = new SysUserEntity();
        reqUser.setUserId(id);
        SysUserEntity sysUser = sysUserService.findUserAllInfo(reqUser);
        return sysUser;
    }
    /**
     * @Author www
     * @Date 2021/6/18 23:38
     * @Description 添加用户信息
     * @param id 用户id
     * @param name 用户名称
     * @param psd 密码
     * @return java.lang.Object
     */
    @PostMapping("/add/{id}/{name}/{psd}")
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody Object add(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUserId(id);
        sysUserEntity.setUserName(name);
        sysUserEntity.setPassWord(psd);
        sysUserService.insertSelective(sysUserEntity);
        return sysUserEntity;
    }
    /**
     * @Author www
     * @Date 2021/6/18 23:38
     * @Description 更新用户信息
     * @param id 用户id
     * @param name 用户名称
     * @param psd 密码
     * @return java.lang.Object
     */
    @PostMapping("/update/{id}/{name}/{psd}")
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody Object update(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
        SysUserEntity sysUserEntity = sysUserService.selectByPrimaryKey(id);
        sysUserEntity.setUserName(name);
        sysUserEntity.setPassWord(psd);
        sysUserService.updateByPrimaryKeySelective(sysUserEntity);
        return sysUserEntity;
    }
}
