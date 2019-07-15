package com.www.demo.cache.service;

import com.www.demo.model.bo.system.Sysroles;

public interface ICacheService {

	public Sysroles savaRoles(Sysroles sysroles);
	
	public Sysroles findOneRoles(Long id);
	
}
