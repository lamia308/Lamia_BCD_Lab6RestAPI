package com.promy.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.promy.studentmanagement.entity.Student;
import com.promy.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	

	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		
		List<Student> theStudents = studentService.findAll();

		
		theModel.addAttribute("Students", theStudents);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		
		Student theStudent = studentService.findById(theId);

		
		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		Student theStudent;

		if (id != 0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstname);
			theStudent.setLastName(lastname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}

		else
			theStudent = new Student(firstname, lastname, course, country);
		
		studentService.save(theStudent);

		
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

	
		studentService.deleteById(theId);

		
		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();

		if (user != null) {

			model.addObject("msg", "Hi" + " " + user.getName() + ",you do not have permission to access this page!");
		}

		else {

			model.addObject("msg", "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}

}
