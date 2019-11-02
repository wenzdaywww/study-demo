package com.www.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.demo.model.bo.system.SysRole;
import com.www.demo.model.bo.system.SysRoleRepository;
import com.www.demo.model.bo.system.SysUser;
import com.www.demo.model.bo.system.SysUserRepository;
/**
 * JPA控制层
 * @author www
 *
 */
@RestController
public class JpaController {
	@Autowired
	private SysRoleRepository sysrolesRepository;
	@Autowired()
	private SysUserRepository sysuserRepository;
	
	@RequestMapping("/saveroles")
	public SysRole saveRoles(String roleid,String rolename) {
		SysRole sysroles = sysrolesRepository.save(new SysRole(roleid, rolename));
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
	public SysUser saveUser(String userid,String username,String passwd) {
		SysUser sysuser = sysuserRepository.save(new SysUser(userid, username, passwd));
		return sysuser;
	}
	
	@RequestMapping("/modifypasswd")
	public int modifyPasswd(String userid,String oldpasswd,String newpasswd) {
		int count = sysuserRepository.modifyPasswd(userid, oldpasswd, newpasswd);
		return count;
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/page")
	public Page<SysUser> page(){
		return sysuserRepository.findAll(new PageRequest(0, 3));
	}
}
