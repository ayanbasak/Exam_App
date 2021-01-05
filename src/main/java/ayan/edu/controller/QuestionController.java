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

import ayan.edu.entity.Question;
import ayan.edu.service.QuestionService;

@Controller
@RequestMapping("/admin/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	public QuestionController(QuestionService theQuestionService) {
		this.questionService = theQuestionService;
	}

	@GetMapping("/list")
	public String listQuestion(Model theModel) {
		List<Question> theQuestion = questionService.findAll();
		theModel.addAttribute("question", theQuestion);
		return "files/list-question";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Question theQuestion = new Question();
		theModel.addAttribute("question", theQuestion);
		return "/files/question-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("question") Question theQuestion) {
		questionService.save(theQuestion);
		return "redirect:/admin/question/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		questionService.deleteById(id);
		return "redirect:/admin/question/list";
	}
}
