package personal.learning.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.services.SchoolService;
import personal.learning.services.UserService;

@Controller
@RequestMapping(value="/authorization")
public class UserAuthController {
	
	private UserService userService;
	
	private SchoolService schoolService;
	
	public UserAuthController(UserService userService, SchoolService schoolService) {
		this.userService = userService;
		this.schoolService = schoolService;
	}
	
	private ModelAndView viewPendingUsersList() {
		ModelAndView modelAndView = new ModelAndView("pendingRejectedAccepted");
		modelAndView.addObject("schoolName", schoolService.getSchoolName());
		modelAndView.addObject("pendingUsers", userService.getPendingUsers());
		modelAndView.addObject("acceptedUsers", userService.getAcceptedUsers());
		modelAndView.addObject("rejectedUsers", userService.getRejectedUsers());
		return modelAndView;
	}
	
	@RequestMapping(value="/acceptAuth", method=RequestMethod.GET)
	public ModelAndView acceptPendingUser(@RequestParam("username") String username) {
		userService.accept(username);
		return viewPendingUsersList();
	}
	
	@RequestMapping(value="/rejectAuth", method=RequestMethod.GET)
	public ModelAndView rejectPendingUser(@RequestParam("username") String username) {
		userService.reject(username);
		return viewPendingUsersList();
	}
}
