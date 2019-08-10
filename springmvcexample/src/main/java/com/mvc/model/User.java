package com.mvc.model;

public class User {

	public User() {
	}
	String firstName;
	String password;
	String user_status;
	
	public User(String firstName, String password) {
		super();
		this.firstName = firstName;
		this.password = password;
		this.user_status="";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
