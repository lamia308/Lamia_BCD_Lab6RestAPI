package com.promy.studentmanagement.service;

import java.util.List;

import com.promy.studentmanagement.entity.Student;

public interface StudentService {
	
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);

}
