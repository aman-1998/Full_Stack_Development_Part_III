package personal.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.model.Customer;

@Controller
public class WebAppController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("homePage");
		return modelAndView;
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public ModelAndView loadForm() {
		ModelAndView modelAndView = new ModelAndView("customerInfoForm");
		Customer customer = new Customer();
		
		//Gender
		Map<String,String> genderMap = new LinkedHashMap<String,String>();
		genderMap.put("MALE", "Male");
		genderMap.put("FEMALE", "Female");
		
		//Country
		Map<String,String> countryMap = new TreeMap<String,String>();
		countryMap.put("Australia", "Australia");
		countryMap.put("France", "France");
		countryMap.put("India", "India");
		countryMap.put("Japan", "Japan");
		countryMap.put("Russia", "Russia");
		countryMap.put("UK", "United Kingdom");
		countryMap.put("USA", "United States of America");
		
		//Language
		Map<String,String> langMap = new LinkedHashMap<String,String>();
		langMap.put("Hindi", "Hindi");
		langMap.put("English", "English");
		langMap.put("Sanskrit", "Sanskrit");
		langMap.put("Maithili", "Maithili");
		
		modelAndView.addObject("genderMap", genderMap);
		modelAndView.addObject("countryMap", countryMap);
		modelAndView.addObject("langMap", langMap);
		
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	// This method should be POST but GET is used just to check server side validation by changing URL parameters.
	@RequestMapping(value="displayInfo", method=RequestMethod.GET)
	public ModelAndView displayInformation(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, SessionStatus status) {
		
		result =  validate(customer.getCountry(), 
						   customer.getLanguage(), 
						   result);
		
		if(customer.getDob() != null) {
			if(!customer.getDob().equals("")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
				Date dateOfBirth = null;
				try {
					dateOfBirth = formatter.parse(customer.getDob());
					customer.setDateOfBirth(dateOfBirth);
				} catch (ParseException e) {
					result.rejectValue("dob", "error.dob.invalid");
				} 
			}
		}
		
		if(result.hasErrors()) {
			ModelAndView repopulatedmodelAndView = new ModelAndView("customerInfoForm");
			//repopulatedmodelAndView.addObject("errorList", errors);
			
			//Gender
			Map<String,String> genderMap = new LinkedHashMap<String,String>();
			genderMap.put("MALE", "Male");
			genderMap.put("FEMALE", "Female");
			
			//Country
			Map<String,String> countryMap = new TreeMap<String,String>();
			countryMap.put("Australia", "Australia");
			countryMap.put("France", "France");
			countryMap.put("India", "India");
			countryMap.put("Japan", "Japan");
			countryMap.put("Russia", "Russia");
			countryMap.put("UK", "United Kingdom");
			countryMap.put("USA", "United States of America");
			
			//Language
			Map<String,String> langMap = new LinkedHashMap<String,String>();
			langMap.put("Hindi", "Hindi");
			langMap.put("English", "English");
			langMap.put("Sanskrit", "Sanskrit");
			langMap.put("Maithili", "Maithili");
			
			repopulatedmodelAndView.addObject("genderMap", genderMap);
			repopulatedmodelAndView.addObject("countryMap", countryMap);
			repopulatedmodelAndView.addObject("langMap", langMap);
			
			repopulatedmodelAndView.addObject("customer", customer);
			return repopulatedmodelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("displayInformation");
			modelAndView.addObject("customer", customer);
			return modelAndView;
		}
	}

	private BindingResult validate(String country, 
								   String[] languages, 
								   BindingResult result) {
		
		//Country Validation
		if(country != null) {
			if(!country.isEmpty()) {
				if(!country.equals("Australia") && !country.equals("France") 
						&& !country.equals("India") && !country.equals("Japan") 
						&& !country.equals("Russia") && !country.equals("UK") 
						&& !country.equals("USA")) {
					result.rejectValue("country", "error.country.invalid");
				}
			}
		}
		
		//Language Validation
		if(languages.length != 0) {
			for(String lang : languages) {
				if(!lang.equals("Hindi") && !lang.equals("English") 
						&& !lang.equals("Sanskrit") && !lang.equals("Maithili")) {
					result.rejectValue("language", "error.language.invalid");
				}
			}
		}
		
		return result;
	}
}
