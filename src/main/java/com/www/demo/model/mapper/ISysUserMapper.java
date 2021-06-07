package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @version 1.0
 * @Description SysUserMapper接口
 * @Author www
 * @Date 2021/5/19 23:39
 */
//@Mapper //扫描Mapper接口，不使用@MapperScan时才使用
public interface ISysUserMapper {
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
     * @Description 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return com.www.demo.model.SysUser 用户信息
     */
    SysUser selectByPrimaryKey(String userId);
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