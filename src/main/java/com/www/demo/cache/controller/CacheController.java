package com.www.demo.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.www.demo.cache.service.ICacheService;
import com.www.demo.model.bo.system.SysRole;
/**
 * 缓存控制层
 * @author www
 *
 */
@RestController
public class CacheController {
	@Autowired
	private ICacheService cacheService;
	
	@RequestMapping("/putcache")
	public SysRole putCache(String roleid, String rolename) {
		return cacheService.savaRoles(roleid, rolename);
	}
	
	@RequestMapping("/ablecache")
	public SysRole ableCache(Long id) {
		return cacheService.findOneRoles(id);
	}
	
	@RequestMapping("/ablecaches")
	public SysRole ableCaches(Long id) {
		SysRole sysroles = new SysRole();
		sysroles.setId(id);
		return cacheService.findOneRoles(sysroles);
	}
}
