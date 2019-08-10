package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Departmet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;
    

    public Departmet() {
	
	}
    
    
    public Departmet(String name) {
  		this.name = name;
  	}
   
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return name;
	}

	

	@Override
	public String toString() {
		return "Department details are id=" + id + ", name=" + name + ";";
	}

}
