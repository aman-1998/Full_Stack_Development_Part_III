package personal.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.service.AppService;

@Controller
public class AppController {
	
	private AppService appService;
	
	// For constructor injection @Autowired is not required (Since Spring 4.3 onwards)
	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/")
	public ModelAndView showHome() {
		ModelAndView home = new ModelAndView("home");
		String schoolName = appService.getSchoolName();
		home.addObject("school", schoolName);
		return home;
	}
}
