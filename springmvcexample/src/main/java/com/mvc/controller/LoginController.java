package com.mvc.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dao.LoginDAO;
import com.mvc.model.ErrorUser;
import com.mvc.model.LoginDetails;
import com.mvc.model.User;

@Controller
public class LoginController {
	
	static Map<String,ErrorUser> error = new HashMap<String,ErrorUser>();
	@Autowired
	LoginDAO userdaoimp;

	@RequestMapping("/logincheck")
	public String logincheck(HttpServletRequest req,Model m)
	{  
		String name = req.getParameter("name");
		System.out.println(name);
		String pass = req.getParameter("pw");
		List<User> users;
		String message;
		users = userdaoimp.getUsers(name);
		System.out.println(users.size());
		message="";
		m.addAttribute("message",message);
		if(users.size()==0)
		{
			message="User does not exit";
			m.addAttribute("message",message);
			return "register";
		}
		
			for(User u: users)
			{   
			
				if(error.containsKey(name))
				{
					ErrorUser e = error.get(name);
				    Timestamp time1=e.getWaiting_time();
				    Date date= new Date();
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					long diffMs = ts.getTime()-time1.getTime();
					long diffSec = diffMs / 1000;
					long min = diffSec / 60;
					long rem;
					switch(e.getErrorcount())
					{
					case 3:if(min<5)
						{rem=5-min;
						message="wait for "+rem+"minutes";
			    	return "loginresult";
						}
					break;
					case 6:if(min<10)
					{rem=10-min;
						message="wait for "+rem+"minutes";
		    	return "loginresult";
					}
				break;
					case 9:if(min<20)
					{rem=20-min;
						message="wait for "+rem+"minutes";
		    	return "loginresult";
					}
				break;
					}
				    
					
					
				}
				if(u.getPassword().equals(pass))
				{

					if(error.containsKey(name))
					{
						error.remove(name);
					}
					String status;
					status="Logged In!";
					message="Successfully Logged In!";
					m.addAttribute("message",message);
					userdaoimp.createAdminView(u.getFirstName(),status);
					status="Logged In!";
					return "loginresult";
				}
				else {
				if(error.containsKey(name))
				{
					ErrorUser e = error.get(name);
					int count=e.getErrorcount()+1;
					e.setErrorcount(count);
					Date date= new Date();
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					e.setWaiting_time(ts);
				    if(count==12)
				    {message="Blocked!";
					m.addAttribute("message",message);
					
				    	String status="User Blocked!";
						userdaoimp.deleteLoggedIn(u.getFirstName());
								  userdaoimp.createAdminView(u.getFirstName(),u.getEmail(),status);
								  userdaoimp.removeRegistered(u.getFirstName());
						          break;
				    }
					
				}
				else 
				{
					int count=1;
					Date date= new Date();
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					ErrorUser e =new ErrorUser(name,count,ts);
					error.put(name, e);
					
				}
				message="Wrong Password";
				m.addAttribute("message",message);
				return "loginresult";
				}
			}
				
			
			System.out.println("User found");
		
		return "loginresult";
	}
	
		
}
