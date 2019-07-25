package com.journaldev.jaxrs.service;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.Response;

//Interface to declare the employee services available
public interface EmployeeService {

	public Response addEmployee(Employee p);
	
	public Response modifyEmployeeName(Employee p);
	
	public Response deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public Employee[] getAllEmployees();

}
