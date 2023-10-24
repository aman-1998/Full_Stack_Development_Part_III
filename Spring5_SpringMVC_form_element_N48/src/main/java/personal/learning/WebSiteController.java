package personal.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.model.Customer;

@Controller
public class WebSiteController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView("customerForm");
		Customer customer = new Customer();
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@RequestMapping(value="displayInfo", method=RequestMethod.GET) // This method should be POST but GET is used just to check server side validation by changing URL parameters.
	public ModelAndView displayInformation(@ModelAttribute Customer customer) {
		ModelAndView modelAndView = new ModelAndView("displayInformation");
		List<String> errors =  validate(customer.getName(), 
										customer.getDob(), 
										customer.getGender(), 
										customer.getCountry(), 
										customer.getLanguage(), 
										customer.getAddress());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
		Date dateOfBirth = null;
		try {
			dateOfBirth = formatter.parse(customer.getDob());
			customer.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			errors.add("Invalid Date");
		} 
		
		if(errors.size() > 0) {
			modelAndView = new ModelAndView("errorPage");
			modelAndView.addObject("errorList", errors);
			return modelAndView;
		}
		modelAndView.addObject("customer", customer);
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
				if(!lang.equals("Hindi") && !lang.equals("English") && !lang.equals("Sanskrit") && !lang.equals("Mathili")) {
					errors.add("Invalid language");
				}
			}
		}
		return errors;
	}
}
