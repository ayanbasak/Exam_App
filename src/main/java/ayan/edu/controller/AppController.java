
package ayan.edu.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ayan.edu.entity.Admin;
import ayan.edu.entity.Answer;
import ayan.edu.entity.Exam;
import ayan.edu.entity.Gexam;
import ayan.edu.entity.Question;
import ayan.edu.entity.Subject;
import ayan.edu.service.AdminService;
import ayan.edu.service.EmailsService;
import ayan.edu.service.ExamService;
import ayan.edu.service.GexamService;
import ayan.edu.service.OexService;
import ayan.edu.service.QuestionService;
import ayan.edu.service.StudentService;
import ayan.edu.service.SubjectService;
import ayan.edu.springsecurity.model.User;
import ayan.edu.springsecurity.service.UserService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private EmailsService emailsService;

	@Autowired
	private ExamService examService;

	@Autowired
	private OexService oexService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private UserService userService;

	@Autowired
	private GexamService gexamService;

	public AppController(AdminService adminService, EmailsService emailsService, ExamService examService,
			OexService oexService, QuestionService questionService, StudentService studentService,
			SubjectService subjectService, GexamService gexamService) {

		this.adminService = adminService;
		this.emailsService = emailsService;
		this.examService = examService;
		this.oexService = oexService;
		this.questionService = questionService;
		this.studentService = studentService;
		this.subjectService = subjectService;
		this.gexamService = gexamService;
	}
	
	@GetMapping("/showFormSub") 
	public String showFormAdd(Model theModel) {
		Subject theSubject = new Subject();
		theModel.addAttribute("subject", theSubject);
		return "app/Subject-form";
	}

	@GetMapping("/admin/addadmin") 
	public String addAdmin(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "app/add-admin";
	}

	@PostMapping("/admin/savead") 
	public String saveAd(@ModelAttribute("user") User theUser) {
		userService.savead(theUser);
		return "redirect:/";
	}

	@GetMapping("/choosesubject/{sname}")
	public String chooseSubject(@PathVariable String sname, Model theModel) {
		List<Gexam> list = gexamService.findBySname(sname);
		theModel.addAttribute("gexam", list);
		return "app/list-gexam";
	}	

	@GetMapping("/chooseQModel/{qname}") // 1
	public String chooseQModel(@PathVariable String qname, Model theModel, Model amodel) {
		theModel.addAttribute("qname", qname);
		return "app/giveexam";
	}

	@GetMapping("/chooseQuestion/{qname}") // 2
	public String chooseQuestion(@PathVariable String qname, Model theModel, Model amodel, Principal principal) {
		String qmodel = qname;
		List<Question> list = questionService.findByQmodel(qmodel);
		Question question = list.get(0);
		theModel.addAttribute("question", question);
		Answer ans = new Answer();
		theModel.addAttribute("ans", ans);
		List<Exam> l = examService.findAll();
		
		int lstno = 0;
		for (Exam n : l) {
			lstno = n.getEid();
		}

		// find user
		User user = userService.findByEmail(principal.getName());

		Exam exam = new Exam();
		exam.setSid(user.getId().intValue());
		exam.setEid(lstno + 1);
		exam.setEname(question.getSubject() + "gexam" + principal.getName());
		exam.setQmodel(question.getQmodel());
		exam.setScore(0);
		examService.save(exam);

		lstno = lstno + 1;

		theModel.addAttribute("examid", lstno);
		return "app/exm-question";
	}

	@PostMapping("/nextQuestion/{id}/{examid}") // 3
	public String nextQuestion(@PathVariable int id, @PathVariable int examid, Model theModel,
			@ModelAttribute("ans") Answer theAns) {
		
		Exam exam = examService.findById(examid);
		Question q1 = questionService.findById(id);

		if (theAns.getGans().equals(q1.getAns())) {
			// Add marks
			exam.setScore(exam.getScore() + q1.getQmark());			
		} 

		Question question = questionService.findById(id + 1);

		if (question == null) {
			int getMarks = exam.getScore();
			theModel.addAttribute("getMarks", getMarks);
			return "app/exam-confirm";
		}

		Answer ans = new Answer();
		theModel.addAttribute("question", question);
		theModel.addAttribute("examid", examid);
		theModel.addAttribute("ans", ans);
		return "app/exm-question";
	}

	@GetMapping("/examc")
	public String examComplete() {
		return "redirect:/app/home";
	}

	@GetMapping("/admin/upcsv") 
	public String uploadcsv(Model theModel) {
		return "app/uploadview";
	}
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/uploads";
	
	@RequestMapping("/admin/uploadfile") 
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();

		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());
		return "app/uploadstatusview";
	}

	@GetMapping("/admin/readcsv") // admin control
	public String readcsv(Model theModel) {

		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(uploadDirectory + "/ques.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Question q = new Question();
				q.setQid(Integer.valueOf(data[0]));
				q.setQmodel(data[1]);
				q.setOpi(data[2]);
				q.setOpii(data[3]);
				q.setOpiii(data[4]);
				q.setOpiv(data[5]);
				q.setAns(data[6]);
				q.setRating(Integer.valueOf(data[7]));
				q.setSubject(data[8]);
				q.setQus(data[9]);
				q.setQmark(Integer.valueOf(data[10]));
				questionService.save(q);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// add questions
		List<Question> list = questionService.findAll();
		theModel.addAttribute("question", list);
		return "app/list-question";
	}

	@GetMapping("/admin/listall") 
	public String listAll() {
		return "app/list-all";
	}
	
}
