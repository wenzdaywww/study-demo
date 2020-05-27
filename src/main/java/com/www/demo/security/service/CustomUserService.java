package com.www.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.www.demo.model.bo.system.SysUser;
import com.www.demo.model.bo.system.SysUserRepository;
/**
 *	 自定义用户查询，这些查询的用户有权限
 * @author www
 *
 */
public class CustomUserService implements UserDetailsService{
	@Autowired
	private SysUserRepository sysUserRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = (SysUser) sysUserRepository.findByUserName(username);
		if (user==null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
