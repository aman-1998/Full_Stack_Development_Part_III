package personal.learning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "basicForm";
	}
	
	@RequestMapping(value="displayInformation", method=RequestMethod.POST)
	public ModelAndView displayInfo(@RequestParam("fname") String fname, 
							  @RequestParam("lname") String lname,
							  @RequestParam("gender") String gender,
							  @RequestParam("language") String[] languages,
							  @RequestParam("country") String country) {
		ModelAndView modelAndView = new ModelAndView("displayAllInformation");
		modelAndView.addObject("fname", fname);
		modelAndView.addObject("lname", lname);
		modelAndView.addObject("gender", gender);
		modelAndView.addObject("languages", languages);
		modelAndView.addObject("country", country);
		return modelAndView;
	}
}
