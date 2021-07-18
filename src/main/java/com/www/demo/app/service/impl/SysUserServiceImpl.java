package com.www.demo.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysMenu;
import com.www.demo.model.entity.SysRole;
import com.www.demo.model.entity.SysUser;
import com.www.demo.model.mapper.ISysRoleMenuMapper;
import com.www.demo.model.mapper.ISysUserMapper;
import com.www.demo.model.mapper.ISysUserRoleMapper;
import com.www.demo.utils.MyBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Description 用户信息服务层
 * @Author www
 * @Date 2021/5/20 23:11
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private ISysUserMapper sysUserMapper;
    @Resource
    private ISysUserRoleMapper sysUserRoleMapper;
    @Resource
    private ISysRoleMenuMapper sysRoleMenuMapper;
    /**
     * @Author www
     * @Date 2021/6/7 22:56
     * @Description 查询用户信息
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUserEntity>
     */
    @Override
    public List<SysUser> findUserList(SysUser user) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        return sysUserMapper.selectList(wrapper);
    }

    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return com.www.demo.model.SysUserEntity 用户信息
     */
    @Override
    public SysUser selectByUserId(String userId) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUser::getUserId,userId);
        return sysUserMapper.selectOne(wrapper);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息（更新非空数据）
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int insertSelective(SysUser record) {
        if(record == null){
            return 0;
        }
        record.setSysCreateDate(new Date());
        record.setSysUpdateDate(new Date());
        record.setIsDelete("0");
        return sysUserMapper.insert(record);
    }
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息（更新非空数据）
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int updateByUserId(SysUser record) {
        if(record == null){
            return 0;
        }
        UpdateWrapper<SysUser> wrapper = new UpdateWrapper<>();
        wrapper.lambda().set(SysUser::getUserName,record.getUserName());
        wrapper.lambda().set(SysUser::getPassWord,record.getPassWord());
        wrapper.lambda().set(SysUser::getIsDelete,record.getIsDelete());
        wrapper.lambda().set(SysUser::getSysUpdateDate, new Date());
        wrapper.lambda().eq(SysUser::getUserId,record.getUserId());
        return sysUserMapper.update(null,wrapper);
    }
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     * @param userId 用户id
     * @return com.www.demo.model.entity.SysUserEntity
     */
    @Override
    public SysUserDTO findUserAllInfo(String userId) {
        SysUser user = selectByUserId(userId);
        if (user == null){
            return null;
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        MyBeanUtils.copyProperties(sysUserDTO,user);
        //查询角色信息
        List<SysRole> roleList = sysUserRoleMapper.findUserRoles(user.getUserId());
        sysUserDTO.setRoleList(roleList);
        //查询菜单信息
        List<SysMenu> menuList = sysRoleMenuMapper.findMenuList(roleList);
        sysUserDTO.setMenuList(menuList);
        return sysUserDTO;
    }
}
