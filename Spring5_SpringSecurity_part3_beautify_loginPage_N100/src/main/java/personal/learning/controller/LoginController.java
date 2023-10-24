package personal.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/customLoginForm")
	public String loginPage() {
		return "loginPage";
	}
}
