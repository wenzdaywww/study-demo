package com.www.demo.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Description 用户角色表对象
 * @Author www
 * @Date 2021/5/19 23:36
 */
public class SysUserRole implements Serializable {
    /**
     * 用户ID
     **/
    private String userId;
    /**
     * 角色ID
     **/
    private String roleId;
    /**
     * 更新时间
     **/
    private Date sysUpdateDate;
    /**
     * 创建时间
     **/
    private Date sysCreateDate;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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