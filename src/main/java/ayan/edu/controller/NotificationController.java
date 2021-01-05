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

import ayan.edu.entity.Notification;
import ayan.edu.service.NotificationService;

@Controller
@RequestMapping("/admin/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	public NotificationController(NotificationService theService) {
		this.notificationService = theService;
	}

	@GetMapping("/list")
	public String listNotification(Model theModel) {
		List<Notification> theNotification = notificationService.findAll();
		theModel.addAttribute("notification", theNotification);
		return "app/list-notification";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Notification theNotification = new Notification();
		theModel.addAttribute("notification", theNotification);
		return "/app/notification-form";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("notification") Notification theNotification) {
		notificationService.save(theNotification);
		return "redirect:/admin/notification/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteNotification(@PathVariable int id) {
		notificationService.deleteById(id);
		return "redirect:/admin/notification/list";
	}
}
