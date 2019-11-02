package com.www.demo.cache.service;

import com.www.demo.model.bo.system.SysRole;
/**
 * 缓存服务层接口
 * @author www
 *
 */
public interface ICacheService {
	/**
	 * 保存角色
	 * @param roleid
	 * @param rolename
	 * @return
	 */
	public SysRole savaRoles(String roleid, String rolename);
	/**
	 * 通过id查询角色
	 * @param id
	 * @return
	 */
	public SysRole findOneRoles(Long id);
	/**
	 * 通过对象查询角色
	 * @param sysroles
	 * @return
	 */
	public SysRole findOneRoles(SysRole sysroles);
}
