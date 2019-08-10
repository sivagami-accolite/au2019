package com.mvc.model;

public class LoginDetails {

	
	public LoginDetails(String username, String password, String status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}
	String username;
	String password;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LoginDetails() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

