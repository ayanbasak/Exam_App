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

import ayan.edu.entity.Emails;
import ayan.edu.service.EmailsService;

@Controller
@RequestMapping("/admin/emails")
public class EmailsController {

	@Autowired
	private EmailsService emailsService;

	public EmailsController(EmailsService theEmailsService) {
		this.emailsService = theEmailsService;
	}

	@GetMapping("/list")
	public String listEmails(Model theModel) {
		List<Emails> theEmails = emailsService.findAll();
		theModel.addAttribute("emails", theEmails);
		return "files/list-emails";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Emails theEmails = new Emails();
		theModel.addAttribute("emails", theEmails);
		return "/files/emails-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("admin") Emails theEmails) {
		emailsService.save(theEmails);
		return "redirect:/admin/emails/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmails(@PathVariable int id) {
		emailsService.deleteById(id);
		return "redirect:/admin/emails/list";
	}
}
