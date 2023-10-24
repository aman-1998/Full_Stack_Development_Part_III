package personal.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "basicForm";
	}
	
	@RequestMapping(value="displayInfo", method=RequestMethod.GET)
	public ModelAndView displayInfo(@RequestParam("name") String name, 
							  @RequestParam("dob") String dob,
							  @RequestParam("gender") String gender,
							  @RequestParam("country") String country,
							  @RequestParam("language") String[] languages,
							  @RequestParam("address") String address) {
		
		ModelAndView modelAndView = new ModelAndView("displayInformation");
		List<String> errors =  validate(name, dob, gender, country, languages, address);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
		Date dateOfBirth = null;
		try {
			dateOfBirth = formatter.parse(dob);
		} catch (ParseException e) {
			errors.add("Invalid Date");
		}  
		
		if(errors.size() > 0) {
			modelAndView = new ModelAndView("errorPage");
			modelAndView.addObject("errorList", errors);
			return modelAndView;
		}
		modelAndView.addObject("name", name);
		
		
		
		modelAndView.addObject("dateOfBirth", dateOfBirth);
		modelAndView.addObject("gender", gender);
		modelAndView.addObject("country", country);
		modelAndView.addObject("languages", languages);
		modelAndView.addObject("address", address);
		return modelAndView;
	}

	private List<String> validate(String name, String dob, String gender, String country, String[] languages, String address) {
		List<String> errors = new ArrayList<String>();
		
		//Name validation
		if(name.equals("")) {
			errors.add("Name can't be empty");
		} 
		
		//DOB validation
		if(dob.equals("")) {
			errors.add("Date of birth can't be empty");
		} else {
			
		}
		
		//Gender validation
		if(gender.equals("")) {
			errors.add("Gender can't be empty");
		} else {
			if(!gender.equals("Male") && !gender.equals("Female")) {
				errors.add("Invalid gender");
			}
		}
		
		//Country Validation
		if(country.equals("")) {
			errors.add("Country can't be empty");
		} 
		
		//Language Validation
		if(languages.length == 0) {
			errors.add("Language can't be empty");
		} else {
			for(String lang : languages) {
				if(!lang.equals("Hindi") && !lang.equals("English") && !lang.equals("Sanskrit") && !lang.equals("Maithili")) {
					errors.add("Invalid language");
				}
			}
		}
		return errors;
	}
}
