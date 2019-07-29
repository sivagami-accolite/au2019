package com.jaxb.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

	public Address() {
	}
	private String city;
	private String state;
	private int zip;
	public Address(String city, String state, int zip) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
}
