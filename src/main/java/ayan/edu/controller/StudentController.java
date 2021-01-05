package ayan.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ayan.edu.entity.Student;
import ayan.edu.service.StudentService;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController(StudentService theStudentService) {
		this.studentService = theStudentService;
	}

	@GetMapping("/list")
	public String listStudent(Model theModel) {
		List<Student> theStudent = studentService.findAll();
		theModel.addAttribute("student", theStudent);
		return "files/list-student";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "/files/student-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("student") Student theStudent) {
		studentService.save(theStudent);
		return "redirect:/admin/student/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
		return "redirect:/admin/student/list";
	}
}
