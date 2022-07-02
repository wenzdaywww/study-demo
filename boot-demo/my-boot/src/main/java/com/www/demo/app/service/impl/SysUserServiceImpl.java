package com.www.demo.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysMenuEntity;
import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.model.mapper.ISysRoleMenuMapper;
import com.www.demo.model.mapper.ISysUserMapper;
import com.www.demo.model.mapper.ISysUserRoleMapper;
import com.www.demo.utils.MyBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>@Description 用户信息服务层  </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:36 </p>
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<ISysUserMapper,SysUserEntity> implements ISysUserService {
    @Resource
    private ISysUserMapper sysUserMapper;
    @Resource
    private ISysUserRoleMapper sysUserRoleMapper;
    @Resource
    private ISysRoleMenuMapper sysRoleMenuMapper;
    /**
     * <p>@Description 查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:36 </p>
     * @param page 当前页数
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUser>
     */
    @Override
    public List<SysUserEntity> findUserList(int page, SysUserEntity user) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        if(user != null && StringUtils.isNotBlank(user.getUserId())){
            wrapper.lambda().eq(SysUserEntity:: getUserId, user.getUserId());
        }
        Page<SysUserEntity> pageLsit = new Page<>(page,10);
        pageLsit = sysUserMapper.selectPage(pageLsit,wrapper);
        return pageLsit.getRecords();
    }

    /**
     * <p>@Description 根据用户ID查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:36 </p>
     * @param userId 用户ID
     * @return com.www.demo.model.entity.SysUser用户信息
     */
    @Override
    public SysUserEntity selectByUserId(String userId) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getUserId,userId);
        return sysUserMapper.selectOne(wrapper);
    }
    /**
     * <p>@Description 插入用户信息（更新非空数据） </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:37 </p>
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int insertSelective(SysUserEntity record) {
        if(record == null){
            return 0;
        }
        record.setSysCreateDate(new Date());
        record.setSysUpdateDate(new Date());
        record.setIsDelete("0");
        return sysUserMapper.insert(record);
    }
    /**
     * <p>@Description 根据主键更新用户信息（更新非空数据） </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:37 </p>
     * @param record 用户信息
     * @return int 插入条数
     */
    @Override
    public int updateByUserId(SysUserEntity record) {
        if(record == null){
            return 0;
        }
        UpdateWrapper<SysUserEntity> wrapper = new UpdateWrapper<>();
        wrapper.lambda().set(SysUserEntity::getUserName,record.getUserName());
        wrapper.lambda().set(SysUserEntity::getPassWord,record.getPassWord());
        wrapper.lambda().set(SysUserEntity::getIsDelete,record.getIsDelete());
        wrapper.lambda().set(SysUserEntity::getSysUpdateDate, new Date());
        wrapper.lambda().eq(SysUserEntity::getUserId,record.getUserId());
        return sysUserMapper.update(null,wrapper);
    }
    /**
     * <p>@Description 查询用户信息，包含角色信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:38 </p>
     * @param userId 用户id
     * @return com.www.demo.model.dto.SysUserDTO
     */
    @Override
    public SysUserDTO findUserAllInfo(String userId) {
        SysUserEntity user = selectByUserId(userId);
        if (user == null){
            return null;
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        MyBeanUtils.copyProperties(user,sysUserDTO);
        //查询角色信息
        List<SysRoleEntity> roleList = sysUserRoleMapper.findUserRoles(user.getUserId());
        sysUserDTO.setRoleList(roleList);
        //查询菜单信息
        List<SysMenuEntity> menuList = sysRoleMenuMapper.findMenuList(roleList);
        sysUserDTO.setMenuList(menuList);
        return sysUserDTO;
    }
}
