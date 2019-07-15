package com.www.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.www.demo.model.bo.system.Sysuser;
import com.www.demo.model.bo.system.SysuserRepository;

@RestController
@RequestMapping("/rest")
public class RestControl {
	@Autowired
	private SysuserRepository sysuserRepository;

	@RequestMapping(method=RequestMethod.GET,value="/user")
	public Sysuser findUser(@RequestParam String username,@RequestParam String passwd) {
		return sysuserRepository.findWithuserNameAndPasswd(username, passwd);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/user")
	public List<Sysuser> findByUsername(){
		return sysuserRepository.findAll();
	}
}
