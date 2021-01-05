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

import ayan.edu.entity.Oex;
import ayan.edu.service.OexService;

@Controller
@RequestMapping("/oex")
public class OexController {

	@Autowired
	private OexService oexService;

	public OexController(OexService theOexService) {
		this.oexService = theOexService;
	}

	@GetMapping("/list")
	public String listOex(Model theModel) {
		List<Oex> theOex = oexService.findAll();
		theModel.addAttribute("oex", theOex);
		return "files/list-oex";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Oex theOex = new Oex();
		theModel.addAttribute("oex", theOex);
		return "/files/oex-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("oex") Oex theOex) {
		oexService.save(theOex);
		return "redirect:/oex/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteOex(@PathVariable int id) {
		oexService.deleteById(id);
		return "redirect:/oex/list";
	}
}
