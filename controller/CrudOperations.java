package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Departmet;
import com.spring.repo.DepartmetRepository;

@RestController
@RequestMapping(value ="spring/departmet")
public class CrudOperations {
	@Autowired
	DepartmetRepository Repository;
	
	@RequestMapping("/insert")
    public String process(){
        Repository.save(new Departmet("Computer Science"));
        Repository.save(new Departmet("IT"));
        Repository.save(new Departmet("ECE"));
        return "Done";
    }
	
	@RequestMapping("/findallDepartments")
    public String findAll(){
        String result = "<html>";
          
        for(Departmet dept :Repository.findAll()){
            result += "<div>" + dept.toString() + "</div>";
        }
          
        return result + "</html>";
    }
	
}

