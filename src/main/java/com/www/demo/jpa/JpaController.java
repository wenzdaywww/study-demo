package com.www.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.demo.model.bo.system.Sysroles;
import com.www.demo.model.bo.system.SysrolesRepository;
import com.www.demo.model.bo.system.Sysuser;
import com.www.demo.model.bo.system.SysuserRepository;

@RestController
public class JpaController {
	@Autowired
	private SysrolesRepository sysrolesRepository;
	@Autowired()
	private SysuserRepository sysuserRepository;
	
	@RequestMapping("/saveroles")
	public Sysroles saveRoles(String roleid,String rolename) {
		Sysroles sysroles = sysrolesRepository.save(new Sysroles(roleid, rolename));
		return sysroles;
	}
	
	@RequestMapping("/findroles")
	public Object findRole(Long id) {
		if (id!=null) {
			return sysrolesRepository.findById(id);
		}else {
			return sysrolesRepository.findAll();
		}
	}
	
	@RequestMapping("/saveuser")
	public Sysuser saveUser(String userid,String username,String passwd) {
		Sysuser sysuser = sysuserRepository.save(new Sysuser(userid, username, passwd));
		return sysuser;
	}
	
	@RequestMapping("/modifypasswd")
	public int modifyPasswd(String userid,String oldpasswd,String newpasswd) {
		int count = sysuserRepository.modifyPasswd(userid, oldpasswd, newpasswd);
		return count;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/page")
	public Page<Sysuser> page(){
		return sysuserRepository.findAll(new PageRequest(0, 3));
	}
}
