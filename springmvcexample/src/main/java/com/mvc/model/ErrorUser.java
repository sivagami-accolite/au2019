package com.mvc.model;

import java.sql.Timestamp;

public class ErrorUser {
String name;
int errorcount;
Timestamp waiting_time;
public ErrorUser(String name, int errorcount, Timestamp waiting_time) {
	super();
	this.name = name;
	this.errorcount = errorcount;
	this.waiting_time = waiting_time;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getErrorcount() {
	return errorcount;
}
public void setErrorcount(int errorcount) {
	this.errorcount = errorcount;
}
public Timestamp getWaiting_time() {
	return waiting_time;
}
public void setWaiting_time(Timestamp waiting_time) {
	this.waiting_time = waiting_time;
}
}
