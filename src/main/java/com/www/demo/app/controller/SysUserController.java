package com.www.demo.app.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Description 用户信息控制层
 * @Author www
 * @Date 2021/5/20 23:14
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;
	
	@RequestMapping("/find/{id}")
	@ResponseBody
	public Object index(@PathVariable("id") String id) {
		SysUserEntity reqUser = new SysUserEntity();
		reqUser.setUserId(id);
		SysUserDTO sysUser = sysUserService.findUserInfo(reqUser);
		return sysUser;
	}

	@RequestMapping("/add/{id}/{name}/{psd}")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody Object add(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
		SysUserEntity sysUserEntity = new SysUserEntity();
		sysUserEntity.setUserId(id);
		sysUserEntity.setUserName(name);
		sysUserEntity.setPassWord(psd);
		sysUserService.insertSelective(sysUserEntity);
		return sysUserEntity;
	}

	@RequestMapping("/update/{id}/{name}/{psd}")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody Object update(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
		SysUserEntity sysUserEntity = sysUserService.selectByPrimaryKey(id);
		sysUserEntity.setUserName(name);
		sysUserEntity.setPassWord(psd);
		sysUserService.updateByPrimaryKeySelective(sysUserEntity);
		return sysUserEntity;
	}

}
