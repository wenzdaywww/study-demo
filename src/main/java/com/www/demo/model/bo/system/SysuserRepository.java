package com.www.demo.model.bo.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SysuserRepository extends JpaRepository<Sysuser, String>{

	public List<Sysuser> findByUserid(String userId);
	
	public List<Sysuser> findByUsername(String userName);
	
	public List<Sysuser> findByPasswd(String passwd);
	
	@Query("select u from Sysuser u where u.username=:username and u.passwd=:passwd")
	public Sysuser findWithuserNameAndPasswd(@Param("username")String userName,@Param("passwd")String passwd);
	
	@Modifying
	@Query("update Sysuser u set u.passwd=:newpasswd where u.userid=:userid and u.passwd=:oldpasswd")
	public int modifyPasswd(@Param("userid")String userid,@Param("oldpasswd")String oldpasswd,@Param("newpasswd")String newpasswd);
}
