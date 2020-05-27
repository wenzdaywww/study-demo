package com.www.demo.model.bo.system;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 角色表的repository
 * @author www
 *
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
	/**
	 *   通过id查询角色
	 * @param id
	 * @return
	 */
	public Optional<SysRole> findById(Long id);
	/**
	 * 通过roleid查询角色
	 * @param roleid
	 * @return
	 */
	public List<SysRole> findByRoleId(String roleid);
	/**
	 * 通过roleName查询角色
	 * @param roleName
	 * @return
	 */
	public List<SysRole> findByRoleName(String roleName);
}
