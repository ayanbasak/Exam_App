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

import ayan.edu.entity.Subject;
import ayan.edu.service.SubjectService;

@Controller
@RequestMapping("/admin/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	public SubjectController(SubjectService theSubjectService) {
		this.subjectService = theSubjectService;
	}

	@GetMapping("/list")
	public String listSubject(Model theModel) {
		List<Subject> theSubject = subjectService.findAll();
		theModel.addAttribute("subject", theSubject);
		return "files/list-subject";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Subject theSubject = new Subject();
		theModel.addAttribute("subject", theSubject);
		return "/files/Subject-form";
	}	

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("admin") Subject theSubject) {
		subjectService.save(theSubject);
		return "redirect:/admin/subject/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteSubject(@PathVariable int id) {
		subjectService.deleteById(id);
		return "redirect:/admin/subject/list";
	}
}
