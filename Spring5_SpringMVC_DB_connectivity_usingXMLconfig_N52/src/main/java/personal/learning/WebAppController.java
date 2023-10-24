package personal.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.DAO.AppDAOImpl;
import personal.learning.model.Customer;
import personal.learning.utility.Utility;

@Controller
public class WebAppController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("homePage");
		return modelAndView;
	}
	
	@RequestMapping(value="viewCustomers", method=RequestMethod.GET)
	public ModelAndView viewAllCustomers() {
		ModelAndView modelAndView = new ModelAndView("listOfAllCustomers");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		List<Customer> listOfCustomers = dao.listCustomers();
		modelAndView.addObject("listOfCustomers", listOfCustomers);
		return modelAndView;
	}
	
	@RequestMapping(value="deleteCustomer", method=RequestMethod.POST)
	public ModelAndView deletionOfCustomer(@RequestParam("email") String email) {
		ModelAndView modelAndView = new ModelAndView("listOfAllCustomers");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		dao.removeCustomer(email);
		List<Customer> listOfCustomers = dao.listCustomers();
		modelAndView.addObject("listOfCustomers", listOfCustomers);
		return modelAndView;
	}
	
	@RequestMapping(value="updateCustomerInfo", method=RequestMethod.GET)
	public ModelAndView updateCustomer(//@RequestParam("operation") String operation,
							   		   @RequestParam("name") String name, 
									   @RequestParam("email") String email,
									   @RequestParam("dob") String dob,
									   @RequestParam("gender") String gender,
									   @RequestParam("country") String country,
									   @RequestParam("countryName") String countryName,
									   @RequestParam("language") String[] language,
									   @RequestParam("address") String address) {
		Date dateOfBirth = Utility.convertDateToDisplayFormat(dob);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dob = formatter.format(dateOfBirth);
		
		Customer customer = new Customer(email, name, gender, dateOfBirth, dob, country, countryName, language, address);
		ModelAndView modelAndView = new ModelAndView("customerInfoForm");
		
		//Gender
		Map<String,String> genderMap = new LinkedHashMap<String,String>();
		genderMap.put("MALE", "Male");
		genderMap.put("FEMALE", "Female");
				
		//Country
		Map<String,String> countryMap = new TreeMap<String,String>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		countryMap = dao.getCountryListfromDB();
				
		//Language
		Map<String,String> langMap = new LinkedHashMap<String,String>();
		langMap.put("Hindi", "Hindi");
		langMap.put("English", "English");
		langMap.put("Sanskrit", "Sanskrit");
		langMap.put("Maithili", "Maithili");
				
		modelAndView.addObject("genderMap", genderMap);
		modelAndView.addObject("countryMap", countryMap);
		modelAndView.addObject("langMap", langMap);	
		modelAndView.addObject("operation", "updateCustomer");
		modelAndView.addObject("originalEmail", customer.getEmail());
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView loadForm() {
		ModelAndView modelAndView = new ModelAndView("customerInfoForm");
		Customer customer = new Customer();
		
		//Gender
		Map<String,String> genderMap = new LinkedHashMap<String,String>();
		genderMap.put("MALE", "Male");
		genderMap.put("FEMALE", "Female");
		
		//Country
		Map<String,String> countryMap = new TreeMap<String,String>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		countryMap = dao.getCountryListfromDB();
		
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
	// Our website should work even if javaScript is disabled for a browser
	@RequestMapping(value="displayInfo", method=RequestMethod.GET)
	public ModelAndView displayInformation(@ModelAttribute("customer") @Valid Customer customer, 
										   BindingResult result,
										   @RequestParam("operation") String operation,
										   @RequestParam("originalEmail") String originalEmail,
										   SessionStatus status) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		
		result =  validate(customer.getCountry(), 
						   customer.getLanguage(),
						   customer.getEmail(),
						   result,
						   operation,
						   originalEmail);
		
		if(customer.getDob() != null) {
			if(!customer.getDob().equals("")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dateOfBirth = null;
				try {
					dateOfBirth = formatter.parse(customer.getDob());
					customer.setDateOfBirth(dateOfBirth);
					customer.setDob(formatter.format(dateOfBirth));
				} catch (ParseException e) {
					result.rejectValue("dob", "error.dob.invalid");
				} 
			}
		}
		
		if(result.hasErrors()) {
			ModelAndView repopulatedmodelAndView = new ModelAndView("customerInfoForm");
			
			//Gender
			Map<String,String> genderMap = new LinkedHashMap<String,String>();
			genderMap.put("MALE", "Male");
			genderMap.put("FEMALE", "Female");
			
			//Country
			Map<String,String> countryMap = new TreeMap<String,String>();
			
			countryMap = dao.getCountryListfromDB();
			
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
			repopulatedmodelAndView.addObject("operation", operation);
			repopulatedmodelAndView.addObject("originalEmail", originalEmail);
			
			return repopulatedmodelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("displayInformation");
			modelAndView.addObject("customer", customer);
			if(operation.equals("updateCustomer")) {
				dao.removeCustomer(originalEmail);
				dao.saveCustomer(customer);
			} else {
				dao.saveCustomer(customer);
			}
			return modelAndView;
		}
	}

	private BindingResult validate(String country, 
								   String[] languages, 
								   String email, BindingResult result, 
								   String operation, String originalEmail) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/personal/learning/DAO/Spring-AppDAOConfig.xml");
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		
		if(operation != null) {
			if(!operation.isEmpty() && !operation.equals("updateCustomer")) {
				result.rejectValue("email", "error.email.invalid.operation.update");
			}
		}
		
		//Country Validation
		if(country != null) {
			if(!country.isEmpty()) {
				int maxPk = dao.getCountryListfromDB().size();
				if(Integer.valueOf(country) > maxPk) {
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
		
		//Email validation
		switch(operation) {
			case "updateCustomer":
				if(email != null) {
					if(email.isEmpty()) {
						result.rejectValue("email", "error.email.empty");
					} else {
						if(!email.equals(originalEmail)) {
							result.rejectValue("email", "error.email.update.notAllowed");
						}
					}
				} else {
					result.rejectValue("email", "error.email.empty");
				}
				break;
			default:
				if(email != null) {
					if(email.isEmpty()) {
						result.rejectValue("email", "error.email.empty");
					} else {
						String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(email);
						boolean isValidEmail = matcher.matches();
						if(!isValidEmail) {
							result.rejectValue("email", "error.email.invalid");
						} else {
							
							boolean isNewCustomer = dao.isNewCustomer(email);
							if(!isNewCustomer) {
								result.rejectValue("email", "error.email.duplicate");
							}
						}
					}
				} else {
					result.rejectValue("email", "error.email.empty");
				}
				break;
		}
		
		
		return result;
	}
}
