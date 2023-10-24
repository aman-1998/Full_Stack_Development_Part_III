package personal.learning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "basicForm";
	}
	
	@RequestMapping(value="displayInformation", method=RequestMethod.POST)
	public String displayInfo(@RequestParam("fname") String fname, 
							  @RequestParam("lname") String lname,
							  @RequestParam("gender") String gender,
							  @RequestParam("language") String[] languages,
							  @RequestParam("country") String country,
							  Model model) {
		model.addAttribute("fname", fname);
		model.addAttribute("lname", lname);
		model.addAttribute("gender", gender);
		model.addAttribute("languages", languages);
		model.addAttribute("country", country);
		return "displayAllInformation";
	}
}
