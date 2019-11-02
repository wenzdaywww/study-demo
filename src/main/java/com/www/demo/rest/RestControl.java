package com.www.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.demo.model.bo.system.SysUser;
import com.www.demo.model.bo.system.SysUserRepository;
/**
 * REST服务控制层
 * @author www
 *
 */
@RestController
@RequestMapping("/rest")
public class RestControl {
	@Autowired
	private SysUserRepository sysuserRepository;

	@RequestMapping(method=RequestMethod.GET,value="/user")
	public SysUser findUser(@RequestParam String username,@RequestParam String passwd) {
		return sysuserRepository.findWithuserNameAndPasswd(username, passwd);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/user")
	public List<SysUser> findByUsername(){
		return sysuserRepository.findAll();
	}
}
