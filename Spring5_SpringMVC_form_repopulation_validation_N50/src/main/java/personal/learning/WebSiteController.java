package personal.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.model.Customer;

@Controller
public class WebSiteController {
	
	// List or errors while submitting form
	private List<String> errors = new ArrayList<String>();
	
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
	
	@RequestMapping(value="displayInfo", method=RequestMethod.GET) // This method should be POST but GET is used just to check server side validation by changing URL parameters.
	public ModelAndView displayInformation(@ModelAttribute Customer customer, BindingResult result, SessionStatus status) {
		
		result =  validate(customer.getName(), 
						   customer.getDob(), 
						   customer.getGender(), 
						   customer.getCountry(), 
						   customer.getLanguage(), 
						   customer.getAddress(),
						   result);
		
		if(!customer.getDob().equals("") && customer.getDob() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
			Date dateOfBirth = null;
			try {
				dateOfBirth = formatter.parse(customer.getDob());
				customer.setDateOfBirth(dateOfBirth);
			} catch (ParseException e) {
				errors.add("Invalid Date");
				result.rejectValue("dob", "error.dob.invalid");
			} 
		}
		
		if(errors.size() > 0) {
			errors = new ArrayList<String>();
			ModelAndView repopulatedmodelAndView = new ModelAndView("customerInfoForm");
			repopulatedmodelAndView.addObject("errorList", errors);
			
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

	private BindingResult validate(String name, 
								  String dob, 
								  String gender, 
								  String country, 
								  String[] languages, 
								  String address,
								  BindingResult result) {
		//Name validation
		if(name.equals("")) {
			errors.add("Name can't be empty");
			result.rejectValue("name", "error.name.empty");
		} 
		
		//DOB validation
		if(dob == null) {
			errors.add("Date of birth can't be empty");
			result.rejectValue("dob", "error.dob.empty");
		} else if (dob.equals("")) {
			errors.add("Date of birth can't be empty");
			result.rejectValue("dob", "error.dob.empty");
		}
		
		//Gender validation
		if(gender == null) {
			errors.add("Gender can't be empty");
			result.rejectValue("gender", "error.gender.empty");
		} else if(gender.equals("")) {
			errors.add("Gender can't be empty");
			result.rejectValue("gender", "error.gender.empty");
		} else {
			if(!gender.equals("MALE") && !gender.equalsIgnoreCase("FEMALE")) {
				errors.add("Invalid gender");
				result.rejectValue("gender", "error.gender.invalid");
			}
		}
		
		//Country Validation
		if(country == null) {
			errors.add("Country can't be empty");
			result.rejectValue("country", "error.country.empty");
		} else if(country.equals("")) {
			errors.add("Country can't be empty");
			result.rejectValue("country", "error.country.empty");
		} else {
			if(!country.equals("Australia") && !country.equals("France") 
					&& !country.equals("India") && !country.equals("Japan") 
					&& !country.equals("Russia") && !country.equals("UK") 
					&& !country.equals("USA")) {
				errors.add("Invalid country");
				result.rejectValue("language", "error.language.invalid");
			}
			
		}
		
		//Language Validation
		if(languages.length == 0) {
			errors.add("Language can't be empty");
			result.rejectValue("language", "error.language.empty");
		} else {
			for(String lang : languages) {
				if(!lang.equals("Hindi") && !lang.equals("English") 
						&& !lang.equals("Sanskrit") && !lang.equals("Maithili")) {
					errors.add("Invalid language");
					result.rejectValue("language", "error.language.invalid");
				}
			}
		}
		return result;
	}
}
