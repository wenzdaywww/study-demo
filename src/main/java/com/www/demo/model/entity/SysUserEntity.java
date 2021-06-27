package com.www.demo.model.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Description 用户表对象
 * @Author www
 * @Date 2021/5/19 23:37
 */
@ApiModel("用户信息")
public class SysUserEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     **/
    private String userName;
    /**
     * 用户密码
     **/
    private String passWord;
    /**
     * 是否删除
     **/
    private String isDelete;
    /**
     * 更新时间
     **/
    private Date sysUpdateDate;
    /**
     * 创建时间
     **/
    private Date sysCreateDate;
    /**
     *用户角色信息
     **/
    private List<SysRoleEntity> roleList;
    /**
     * 用户权限菜单
     **/
    private List<SysMenuEntity> menuList;

    public List<SysRoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRoleEntity> roleList) {
        this.roleList = roleList;
    }

    public List<SysMenuEntity> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenuEntity> menuList) {
        this.menuList = menuList;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getSysUpdateDate() {
        return sysUpdateDate;
    }

    public void setSysUpdateDate(Date sysUpdateDate) {
        this.sysUpdateDate = sysUpdateDate;
    }

    public Date getSysCreateDate() {
        return sysCreateDate;
    }

    public void setSysCreateDate(Date sysCreateDate) {
        this.sysCreateDate = sysCreateDate;
    }
}