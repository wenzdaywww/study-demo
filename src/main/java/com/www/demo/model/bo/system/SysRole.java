package com.www.demo.model.bo.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 1、使用@Entity注解，不需要@Table和@Column
 * 2、实体类名必须与表名一样，如SysRoles对应的表名为sys_roles，Sysroles对应sysroles
 * 3、必须使用@Id指定其主键，否则启动报错
 * 4、可以使用@GeneratedValue(generator="seq_sysroles_id")指定序列名
 * 5、实体类需要无参构造方法，否则调用某些方法报错
 * 6、属性名必须与表字段一样，如属性userId对应表字段user_id，userid对应userid。属性必须在表中有对应的字段，但表中的字段在实体中可以没有对应属性变量。
 * @author www
 *
 */
@Entity
public class SysRole {

	@Id
	@GeneratedValue(generator="seq_sysroles_id")
	private Long id;

	private String roleId;

	private String roleName;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysRole( String roleid, String rolename) {
		super();
		this.roleId = roleid;
		this.roleName = rolename;
	}

	public SysRole() {
		super();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
