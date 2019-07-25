
package com.journaldev.jaxrs.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//imports rest service operations that have been made available by using dependency
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.Response;
//Sets the path component to Employee to access functions
@Path("/Employee")
//used to mention that the output and input for the employee class is xml
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Integer,Employee> Employees = new HashMap<Integer,Employee>();
	
	//adds a new employee by accepting xml from request
	@Override
	@POST
    @Path("/add")
	public Response addEmployee(Employee p) {
		Response response = new Response();
		if(Employees.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			return response;
		}
		Employees.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return response;
	}
	
	//deletes a employee by using id
	@Override
	@GET
    @Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		Response response = new Response();
		if(Employees.get(id) == null){
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			return response;
		}
		Employees.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return response;
	}

	//fetches a employee by using id
	@Override
	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		return Employees.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		Employee p = new Employee();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	//fetches all employee
	@Override
	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		Set<Integer> ids = Employees.keySet();
		Employee[] p = new Employee[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = Employees.get(id);
			i++;
		}
		return p;
	}
	//modifies a employee name
	@Override
	@POST
    @Path("/modifyName")
	public Response modifyEmployeeName(Employee p) {
		Response response = new Response();
		if(Employees.get(p.getId()) == null){
			response.setStatus(false);
			response.setMessage("Employee Does not Exists");
			return response;
		}
		Employee e=Employees.get(p.getId());
		e.setName(p.getName());
		response.setStatus(true);
		response.setMessage("Employee modified successfully");
		return response;
	}

	

}
