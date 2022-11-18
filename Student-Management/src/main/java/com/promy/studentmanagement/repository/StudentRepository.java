package com.promy.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promy.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository <Student, Integer>{

}
