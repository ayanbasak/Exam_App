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

import ayan.edu.entity.Admin;
import ayan.edu.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	public AdminController(AdminService theAdminService) {
		this.adminService = theAdminService;
	}

	@GetMapping("/list")
	public String listAdmin(Model theModel) {
		List<Admin> theAdmin = adminService.findAll();
		theModel.addAttribute("admin", theAdmin);
		return "files/list-admin";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Admin theAdmin = new Admin();
		theModel.addAttribute("admin", theAdmin);
		return "/files/admin-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("admin") Admin theAdmin) {
		adminService.save(theAdmin);
		return "redirect:/admin/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable int id) {
		adminService.deleteById(id);
		return "redirect:/admin/list";
	}
}
