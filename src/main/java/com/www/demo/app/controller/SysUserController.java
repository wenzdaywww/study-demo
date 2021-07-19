package com.www.demo.app.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.common.ResponseEnum;
import com.www.demo.model.common.ResponseMsg;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Description 用户信息控制层，用于测试Mybatis
 * @Author www
 * @Date 2021/5/20 23:14
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;

	/**
	 * @Author www
	 * @Date 2021/6/18 23:38
	 * @Description 根据用户ID查询用户信息
	 *
	 * @param id 用户id
	 * @return java.lang.Object
	 */
	@RequestMapping("/find/{id}")
	@ResponseBody
	public ResponseMsg<SysUserDTO> index(@PathVariable("id") String id) {
		SysUserDTO sysUserDTO = sysUserService.findUserAllInfo(id);
		return new ResponseMsg<>(ResponseEnum.SUCCESS,sysUserDTO);
	}
	/**
	 * @Author www
	 * @Date 2021/6/18 23:38
	 * @Description 添加用户信息
	 *
	 * @param id 用户id
	 * @param name 用户名称
	 * @param psd 密码
	 * @return java.lang.Object
	 */
	@RequestMapping("/add/{id}/{name}/{psd}")
	public @ResponseBody ResponseMsg<SysUser> add(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.insertSelective(sysUser);
		return new ResponseMsg<>(ResponseEnum.SUCCESS,sysUser);
	}
	/**
	 * @Author www
	 * @Date 2021/6/18 23:38
	 * @Description 更新用户信息
	 *
	 * @param id 用户id
	 * @param name 用户名称
	 * @param psd 密码
	 * @return java.lang.Object
	 */
	@RequestMapping("/update/{id}/{name}/{psd}")
	public @ResponseBody ResponseMsg<SysUser> update(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("psd")String psd){
		SysUser sysUser = sysUserService.selectByUserId(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.updateByUserId(sysUser);
		return new ResponseMsg<>(ResponseEnum.SUCCESS,sysUser);
	}

}
