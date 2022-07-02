package com.www.demo.app.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.common.ResponseEnum;
import com.www.demo.model.common.ResponseDTO;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>@Description  用户信息控制层，用于测试Mybatis </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:34 </p>
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;

	/**
	 * <p>@Description 根据用户ID查询用户信息 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 20:34 </p>
	 * @param id 用户id
	 * @return com.www.demo.model.common.ResponseDTO<com.www.demo.model.dto.SysUserDTO>
	 */
	@RequestMapping("/find/{id}")
	@ResponseBody
	public ResponseDTO<SysUserDTO> index(@PathVariable("id") String id) {
		SysUserDTO sysUserDTO = sysUserService.findUserAllInfo(id);
		return new ResponseDTO<>(ResponseEnum.SUCCESS,sysUserDTO);
	}
	/**
	 * <p>@Description 添加用户信息 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 20:35 </p>
	 * @param id 用户id
	 * @param name 用户名称
	 * @param psd 密码
	 * @return com.www.demo.model.common.ResponseDTO<com.www.demo.model.entity.SysUser>
	 */
	@RequestMapping("/add/{id}/{name}/{psd}")
	public @ResponseBody ResponseDTO<SysUserEntity> add(@PathVariable("id")String id, @PathVariable("name")String name, @PathVariable("psd")String psd){
		SysUserEntity sysUser = new SysUserEntity();
		sysUser.setUserId(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.insertSelective(sysUser);
		return new ResponseDTO<>(ResponseEnum.SUCCESS,sysUser);
	}
	/**
	 * <p>@Description 更新用户信息 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 20:35 </p>
	 * @param id 用户id
	 * @param name 用户名称
	 * @param psd 密码
	 * @return com.www.demo.model.common.ResponseDTO<com.www.demo.model.entity.SysUser>
	 */
	@RequestMapping("/update/{id}/{name}/{psd}")
	public @ResponseBody ResponseDTO<SysUserEntity> update(@PathVariable("id")String id, @PathVariable("name")String name, @PathVariable("psd")String psd){
		SysUserEntity sysUser = sysUserService.selectByUserId(id);
		sysUser.setUserName(name);
		sysUser.setPassWord(psd);
		sysUserService.updateByUserId(sysUser);
		return new ResponseDTO<>(ResponseEnum.SUCCESS,sysUser);
	}

}
