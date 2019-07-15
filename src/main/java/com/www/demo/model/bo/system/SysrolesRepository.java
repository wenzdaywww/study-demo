package com.www.demo.model.bo.system;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SysrolesRepository extends JpaRepository<Sysroles, Long> {
	
	public Optional<Sysroles> findById(Long id);
	
	public List<Sysroles> findByRoleid(String roleid);
	
	public List<Sysroles> findByRolename(String roleName);
}
