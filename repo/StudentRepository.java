package com.spring.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
