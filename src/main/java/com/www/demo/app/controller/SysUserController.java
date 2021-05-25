package com.www.demo.app.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
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
	
	@RequestMapping("/find")
	@ResponseBody
	public Object index(String id) {
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		return sysUser;
	}

	@RequestMapping("/add")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody Object add(String id,String name,String psd){
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.insertSelective(sysUser);
		return sysUser;
	}

	@RequestMapping("/update")
	@Transactional(rollbackFor = Exception.class)
	public @ResponseBody Object update(String id,String name,String psd){
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.updateByPrimaryKeySelective(sysUser);
		return sysUser;
	}

}
