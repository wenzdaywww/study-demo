package com.www.demo.app.service;

import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUser;

import java.util.List;

/**
 * @version 1.0
 * @Description 用户信息服务接口
 * @Author www
 * @Date 2021/5/20 23:14
 */
public interface ISysUserService {
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     *
     * @param req 查询条件
     * @return com.www.demo.model.dto.SysUserDTO
     */
    SysUserDTO findUserInfo(SysUser req);
    /**
     * @Author www
     * @Date 2021/6/7 22:56
     * @Description 查询用户信息
     *
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUser>
     */
    List<SysUser> findUserList(SysUser user);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return com.www.demo.model.SysUser 用户信息
     */
    SysUser selectByPrimaryKey(String userId);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int insertSelective(SysUser record);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据主键删除用户信息
     *
     * @param userId 用户ID
     * @return int 删除条数
     */
    int deleteByPrimaryKey(String userId);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int insert(SysUser record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int updateByPrimaryKeySelective(SysUser record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int updateByPrimaryKey(SysUser record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据用户信息（更新非空数据）查询用户信息
     *
     * @param record 用户信息
     * @return int 用户信息
     */
    SysUser selective(SysUser record);
}
