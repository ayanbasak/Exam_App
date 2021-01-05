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

import ayan.edu.entity.EQ;
import ayan.edu.service.EQService;

@Controller
@RequestMapping("/eq")
public class EQController {

	@Autowired
	private EQService eqService;

	public EQController(EQService theEQService) {
		this.eqService = theEQService;
	}

	@GetMapping("/list")
	public String listEQ(Model theModel) {
		List<EQ> theEQ = eqService.findAll();
		theModel.addAttribute("eq", theEQ);
		return "files/list-eq";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		EQ theEQ = new EQ();
		theModel.addAttribute("eq", theEQ);
		return "files/eq-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("eq") EQ theEQ) {
		eqService.save(theEQ);
		return "redirect:/eq/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEQ(@PathVariable int id) {
		eqService.deleteById(id);
		return "redirect:/eq/list";
	}
}
