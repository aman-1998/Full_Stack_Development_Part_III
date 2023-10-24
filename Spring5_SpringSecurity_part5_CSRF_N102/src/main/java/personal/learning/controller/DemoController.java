package personal.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String homePage() {
		return "home";
	}
}
