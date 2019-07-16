package com.www.demo.model.vo;
/**
 * 
 * @author www
 *
 */
public class SysuserVO {
	
	private String userId;
	
	private String userName;
	
	private String passwd;
	
	private String oldPasswd;
	
	private String newPasswd;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getOldPasswd() {
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

	public SysuserVO(String userId, String userName, String passwd, String oldPasswd, String newPasswd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passwd = passwd;
		this.oldPasswd = oldPasswd;
		this.newPasswd = newPasswd;
	}

	@Override
	public String toString() {
		return "SysuserVO [userId=" + userId + ", userName=" + userName + ", passwd=" + passwd + ", oldPasswd="
				+ oldPasswd + ", newPasswd=" + newPasswd + "]";
	}
}
