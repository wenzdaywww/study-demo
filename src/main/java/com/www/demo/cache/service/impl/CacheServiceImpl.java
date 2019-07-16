package com.www.demo.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.www.demo.cache.service.ICacheService;
import com.www.demo.model.bo.system.Sysroles;
import com.www.demo.model.bo.system.SysrolesRepository;
/**
 * 缓存服务层
 * @author www
 *
 */
@Service
public class CacheServiceImpl implements ICacheService{
	@Autowired
	private SysrolesRepository sysrolesRepository;

	@Override
	@Transactional
	@CachePut(key="'sysroles.roleid'",value="sysroles")
	public Sysroles savaRoles(String roleid, String rolename) {
		System.out.println("添加缓存。。。");
		Sysroles sysroles = new Sysroles(roleid, rolename);
		return sysrolesRepository.save(sysroles);
	}

	@Override
	@Cacheable(key="#id",value="sysroles")
	public Sysroles findOneRoles(Long id) {
		System.out.println("id查询缓存是否存在。。。。");
		return sysrolesRepository.findById(id).get();
	}
	
	@Override
	@Cacheable(key="#sysroles.id",value="sysroles") 
	public Sysroles findOneRoles(Sysroles sysroles) {
		System.out.println("对象查询缓存是否存在。。。。");
		return sysrolesRepository.findById(sysroles.getId()).get();
	}

}
