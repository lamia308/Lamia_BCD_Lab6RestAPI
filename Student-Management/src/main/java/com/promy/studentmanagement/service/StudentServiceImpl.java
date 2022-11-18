package com.promy.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promy.studentmanagement.entity.Student;
import com.promy.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {

		List<Student> students = studentRepository.findAll();

		return students;
	}

	@Override
	public Student findById(int id) {


		return studentRepository.findById(id).get();
	}

	@Override
	public void save(Student theStudent) {

		studentRepository.save(theStudent);

	}

	@Override
	public void deleteById(int id) {

		studentRepository.deleteById(id);

	}

}
