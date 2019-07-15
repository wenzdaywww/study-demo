package com.www.demo.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.www.demo.cache.service.ICacheService;
import com.www.demo.model.bo.system.Sysroles;

@Controller
public class CacheController {
	@Autowired
	private ICacheService cacheService;
	
	@RequestMapping("/putcache")
	public Sysroles putCache(Sysroles sysroles) {
		return cacheService.savaRoles(sysroles);
	}
	
	@RequestMapping("/ablecache")
	public Sysroles ableCache(Long id) {
		return cacheService.findOneRoles(id);
	}
}
