package com.www.demo.model.bo.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 * 用户表的repository
 * @author www
 *
 */
public interface SysUserRepository extends JpaRepository<SysUser, String>{
	/**
	 * 通过userId查询用户
	 * @param userId
	 * @return
	 */
	public List<SysUser> findByUserId(String userId);
	/**
	 * 通过userName查询用户
	 * @param userName
	 * @return
	 */
	public List<SysUser> findByUserName(String userName);
	/**
	 * 通过passwd查询用户
	 * @param passwd
	 * @return
	 */
	public List<SysUser> findByPassWord(String passwd);
	/**
	 * 通过userName和passwd查询用户
	 * @param userName
	 * @param passwd
	 * @return
	 */
	@Query("select u from SysUser u where u.userName=:username and u.passWord=:passwd")
	public SysUser findWithuserNameAndPasswd(@Param("username")String userName,@Param("passwd")String passwd);
	/**
	 * 修改用户密码
	 * @param userid
	 * @param oldpasswd
	 * @param newpasswd
	 * @return
	 */
	@Modifying
	@Query("update SysUser u set u.passWord=:newpasswd where u.userId=:userid and u.passWord=:oldpasswd")
	public int modifyPasswd(@Param("userid")String userid,@Param("oldpasswd")String oldpasswd,@Param("newpasswd")String newpasswd);
}
