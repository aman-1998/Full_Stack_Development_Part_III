package personal.learning.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.services.SchoolService;
import personal.learning.services.UserService;

@Controller
public class AppController {
	
	private UserService userService;
	
	private SchoolService schoolService;
	
	public AppController(UserService userService, SchoolService schoolService) {
		this.userService = userService;
		this.schoolService = schoolService;
	}
	
	private ModelAndView init() {
		ModelAndView modelAndView = new ModelAndView();
		String schoolName = schoolService.getSchoolName();
		modelAndView.addObject("schoolName", schoolName);
		return modelAndView;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value="/myLogin", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("loginPage");
		return modelAndView;
	}
	
	@GetMapping("/viewPendingUsers")
	public ModelAndView showPendingUsers() {
		ModelAndView modelAndView = init();
		modelAndView.addObject("pendingUsers", userService.getPendingUsers());
		modelAndView.setViewName("listOfPendingUsers");
		return modelAndView;
	}
	
	@GetMapping("/notice")
	public ModelAndView showNotice() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("notice");
		return modelAndView;
	}
	
	@GetMapping("/holiday")
	public ModelAndView showHolidhay() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("holiday");
		return modelAndView;
	}
	
	@GetMapping("/admission")
	public ModelAndView showAdmission() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("admission");
		return modelAndView;
	}
	
	@GetMapping("/performance")
	public ModelAndView showPerformance() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("performance");
		return modelAndView;
	}
	
	@GetMapping("/pendingFees")
	public ModelAndView showPendingFees() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("pendingFees");
		return modelAndView;
	}
	
	@GetMapping("/about")
	public ModelAndView showAbout() {
		ModelAndView modelAndView = init();
		modelAndView.setViewName("about");
		return modelAndView;
	} 
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "accessDeniedPage";
	}
}
