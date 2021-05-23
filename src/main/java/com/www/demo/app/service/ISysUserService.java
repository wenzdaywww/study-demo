package com.www.demo.app.service;

import com.www.demo.model.entity.SysUser;

/**
 * @version 1.0
 * @Description 用户信息服务接口
 * @Author www
 * @Date 2021/5/20 23:14
 */
public interface ISysUserService {
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
}
