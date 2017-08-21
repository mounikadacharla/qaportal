package com.alacriti.qaportal.model.vo;

public class UserLoginVO {
	public String userName;
	public String password;

	public UserLoginVO() {

	}

	public UserLoginVO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
