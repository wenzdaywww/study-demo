package com.www.demo.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.www.demo.cache.service.ICacheService;
import com.www.demo.model.bo.system.Sysroles;
import com.www.demo.model.bo.system.SysrolesRepository;
@Service
public class CacheServiceImpl implements ICacheService{
	@Autowired
	private SysrolesRepository sysrolesRepository;

	@Override
	@Transactional
	@CachePut(key="sysroles",value="#sysroles.roleid")
	public Sysroles savaRoles(Sysroles sysroles) {
		System.out.println("添加缓存。。。");
		return sysrolesRepository.save(sysroles);
	}

	@Override
	@Cacheable(key="sysroles",value="#sysroles.roleid")
	public Sysroles findOneRoles(Long id) {
		System.out.println("查询缓存是否存在。。。。");
		return sysrolesRepository.findById(id).get();
	}

}
