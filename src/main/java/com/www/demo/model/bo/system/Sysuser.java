package com.www.demo.model.bo.system;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sysuser {
	@Id
	private String userid;
	
	private String username;
	
	private String passwd;


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Sysuser(String userid, String username, String passwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.passwd = passwd;
	}

	public Sysuser() {
		super();
	}
	
	
}
