package personal.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	
	@RequestMapping(value="/myLogin", method=RequestMethod.GET)
	public String showLoginPage() {
		return "loginPage";
	}
	
	@GetMapping("/notice")
	public String showNotice() {
		return "notice";
	}
	
	@GetMapping("/holiday")
	public String showHolidhay() {
		return "holiday";
	}
	
	@GetMapping("/admission")
	public String showAdmission() {
		return "admission";
	}
	
	@GetMapping("/performance")
	public String showPerformance() {
		return "performance";
	}
	
	@GetMapping("/pendingFees")
	public String showPendingFees() {
		return "pendingFees";
	}
	
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "accessDeniedPage";
	}
}
