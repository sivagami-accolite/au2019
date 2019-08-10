package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Student;
import com.spring.repo.StudentRepository;
 
@RestController
public class WebController {
	@Value("${val}")
	private int val;
    @Autowired
    StudentRepository reposit;
      
    @RequestMapping("/save")
    public String process(){
        reposit.save(new Student("Sivagami", "Sankaralingam"));
        reposit.save(new Student("Samyuktha", "Venkatesan"));
        reposit.save(new Student("Krishna", "Nedunchezian"));
        reposit.save(new Student("Srikanth", "Sridhar"));
        return "Done";
    }
      
    @RequestMapping("/findStudents")
    public String findAll(){
        String result = "<html>";
        result+="<div>" +"There "+val+" students in the db are." + "</div>";
        for(Student studs : reposit.findAll()){
            result += "<div>" + studs.toString() + "</div>";
        }
       
        return result +"</html>";
    }
      
    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = reposit.findById(id).toString();
        return result;
    }
      
   
}