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

import ayan.edu.entity.Exam;
import ayan.edu.service.ExamService;

@Controller
@RequestMapping("/admin/exam")
public class ExamController {

	@Autowired
	private ExamService examService;

	public ExamController(ExamService theExamService) {
		this.examService = theExamService;
	}

	@GetMapping("/list")
	public String listExam(Model theModel) {
		List<Exam> theExam = examService.findAll();
		theModel.addAttribute("exam", theExam);
		return "files/list-exam";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Exam theExam = new Exam();
		theModel.addAttribute("exam", theExam);
		return "/files/exam-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("exam") Exam theExam) {
		examService.save(theExam);
		return "files/list-exam";
	}

	@GetMapping("/delete/{id}")
	public String deleteExam(@PathVariable int id) {
		examService.deleteById(id);
		return "redirect:/admin/exam/list";
	}
}
