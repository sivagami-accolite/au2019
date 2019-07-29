package com.jaxb.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private Address add;
	
	public Employee() {
	}

	public Employee(int empId, String firstName, String lastName, Address add) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.add = add;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", add=" + add + "]";
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
}
