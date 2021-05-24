package com.www.demo.app.service.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import com.www.demo.model.mapper.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Description 用户信息服务层
 * @Author www
 * @Date 2021/5/20 23:11
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private ISysUserMapper sysUserMapper;
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return com.www.demo.model.SysUser 用户信息
     */
    @Override
    public SysUser selectByPrimaryKey(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据主键删除用户信息
     *
     * @param userId 用户ID
     * @return int 删除条数
     */
    @Override
    public int deleteByPrimaryKey(String userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据用户信息（更新非空数据）查询用户信息
     *
     * @param record 用户信息
     * @return int 用户信息
     */
    @Override
    public SysUser selective(SysUser record) {
        if (record != null){
            return sysUserMapper.selective(record);
        }
        return null;
    }
}
