package com.alacriti.qaportal.model.vo;

public class LoginValidation {
	public int sid;
	public String userName;
	public boolean isValid;
	public LoginValidation(int sid, String userName, boolean isValid) {
		super();
		this.sid = sid;
		this.userName = userName;
		this.isValid = isValid;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
