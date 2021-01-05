package ayan.edu.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ayan.edu.entity.Notification;
import ayan.edu.entity.Subject;
import ayan.edu.service.NotificationService;
import ayan.edu.service.SubjectService;
import ayan.edu.springsecurity.model.User;
import ayan.edu.springsecurity.service.UserService;

@Controller
public class MainController {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private NotificationService notificationService;
	

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String examComplete() {
		return "redirect:/home";
	}


	@GetMapping("/home")
	public String root(Model theModel) {

		List<Subject> theSubject = subjectService.findAll();
		List<Notification> theNotification = notificationService.findAll();		
		
		theModel.addAttribute("subject", theSubject);
		theModel.addAttribute("notif", theNotification);
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/admin/listusers")
	public String listAdmin(Model theModel) {

		List<User> theUser = userService.findAll();

		theModel.addAttribute("user", theUser);

		return "app/list-user";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}	
}
