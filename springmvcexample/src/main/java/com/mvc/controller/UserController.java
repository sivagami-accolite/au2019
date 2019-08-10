package com.mvc.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dao.LoginDAO;
import com.mvc.model.User;

@Controller
public class UserController {
	
	@Autowired
	LoginDAO log;
	
	@RequestMapping("/home")
	public String create(Model m)
	{
		String message="";
		m.addAttribute("message",message);
		return "register";
	}
	

	@RequestMapping("/admin")
	public String adminLogin()
	{
		return "admin";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest req,Model m)
	{
		String name=req.getParameter("name");
		String password=req.getParameter("pw");
		String message;
		message="Welcome" + name+"!";
		m.addAttribute("message", message);
		User u = new User(name,password);
		log.save(u);
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model m)
	{
		String message = "";
		m.addAttribute("message", message);
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminView(HttpServletRequest req,Model m)
	{
		String name=req.getParameter("name");
		String pass=req.getParameter("pw");
		if(name.equals("sivagami") && pass.equals("sivagami"))
		{		
				m.addAttribute("users",log.viewUser());
				return "view";
		}
		else
			return "admin";
	}
	
}
