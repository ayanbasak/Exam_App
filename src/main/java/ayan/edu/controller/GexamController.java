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

import ayan.edu.entity.Gexam;
import ayan.edu.service.GexamService;

@Controller
@RequestMapping("/admin/gexam")
public class GexamController {

	@Autowired
	private GexamService gexamService;

	public GexamController(GexamService theGexamService) {
		this.gexamService = theGexamService;
	}

	@GetMapping("/list")
	public String listGexam(Model theModel) {
		List<Gexam> theGexam = gexamService.findAll();
		theModel.addAttribute("gexam", theGexam);
		return "files/list-gexam";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Gexam theGexam = new Gexam();
		theModel.addAttribute("gexam", theGexam);
		return "/files/gexam-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("gexam") Gexam theGexam) {
		gexamService.save(theGexam);
		return "redirect:/admin/gexam/list";	}

	@GetMapping("/delete/{id}")
	public String deleteGexam(@PathVariable int id) {
		gexamService.deleteById(id);
		return "redirect:/admin/gexam/list";
	}
}
