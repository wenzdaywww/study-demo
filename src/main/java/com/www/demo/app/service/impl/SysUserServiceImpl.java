package com.www.demo.app.service.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysMenuEntity;
import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.model.mapper.ISysRoleMenuMapper;
import com.www.demo.model.mapper.ISysUserMapper;
import com.www.demo.model.mapper.ISysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private ISysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private ISysRoleMenuMapper sysRoleMenuMapper;
    /**
     * @Author www
     * @Date 2021/6/7 22:56
     * @Description 查询用户信息
     *
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUserEntity>
     */
    @Override
    public List<SysUserEntity> findUserList(SysUserEntity user) {
        return sysUserMapper.findUserList(user);
    }

    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return com.www.demo.model.SysUserEntity 用户信息
     */
    @Override
    public SysUserEntity selectByPrimaryKey(String userId) {
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
    public int insertSelective(SysUserEntity record) {
        return sysUserMapper.insertSelective(record);
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
    public int updateByPrimaryKeySelective(SysUserEntity record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
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
    public SysUserEntity selective(SysUserEntity record) {
        if (record != null){
            return sysUserMapper.selective(record);
        }
        return null;
    }
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     *
     * @param reqUser 查询条件
     * @return com.www.demo.model.entity.SysUserEntity
     */
    @Override
    public SysUserEntity findUserAllInfo(SysUserEntity reqUser) {
        SysUserEntity user = selective(reqUser);
        List<SysRoleEntity> roleList = sysUserRoleMapper.findUserRoles(reqUser.getUserId());
        user.setRoleList(roleList);
        List<SysMenuEntity> menuList = sysRoleMenuMapper.findMenuList(roleList);
        user.setMenuList(menuList);
        return user;
    }
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     * @param userId 用户id
     * @return com.www.demo.model.entity.SysUserEntity
     */
    @Override
    public SysUserEntity findUserAllInfo(String userId) {
        SysUserEntity user = selectByPrimaryKey(userId);
        if (user == null){
            return null;
        }
        List<SysRoleEntity> roleList = sysUserRoleMapper.findUserRoles(userId);
        user.setRoleList(roleList);
        List<SysMenuEntity> menuList = sysRoleMenuMapper.findMenuList(roleList);
        user.setMenuList(menuList);
        return user;
    }
}
