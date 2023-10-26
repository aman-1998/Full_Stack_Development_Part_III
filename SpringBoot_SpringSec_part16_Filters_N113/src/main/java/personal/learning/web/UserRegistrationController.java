package personal.learning.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import personal.learning.services.SchoolService;
import personal.learning.services.UserService;
import personal.learning.web.dto.UserRegistrationDTO;
import personal.learning.web.validation.UserRegistrationValidator;

@Controller
@RequestMapping(value="/registration")
public class UserRegistrationController {
	
	private UserService userService;
	
	private SchoolService schoolService;
	
	public UserRegistrationController(UserService userService, SchoolService schoolService) {
		this.userService = userService;
		this.schoolService = schoolService;
	}
	
	@GetMapping
	public ModelAndView loadRegistrationForm() {
		UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
		ModelAndView modelAndView = initRegistration(userRegistrationDTO);
		return modelAndView;
	}
	
	private ModelAndView initRegistration(UserRegistrationDTO userRegistrationDTO) {
		
		ModelAndView modelAndView = new ModelAndView("registrationPage");
		//userService.test();
		String schoolName = schoolService.getSchoolName();
		
		LinkedHashMap<String, String> genderMap = new LinkedHashMap<>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		
		LinkedHashMap<String, String> countryMap = new LinkedHashMap<>();
		countryMap = userService.getCountryMap();
		
		LinkedHashMap<String, String> langMap = new LinkedHashMap<>();
		langMap = userService.getLangMap();
		
		LinkedHashMap<String, String> roleMap = new LinkedHashMap<>();
		roleMap = userService.getRoleMap();
		
		modelAndView.addObject("user", userRegistrationDTO);
		modelAndView.addObject("genderMap", genderMap);
		modelAndView.addObject("countryMap", countryMap);
		modelAndView.addObject("langMap", langMap);
		modelAndView.addObject("roleMap", roleMap);
		modelAndView.addObject("schoolName", schoolName);
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView registrationHandler(@ModelAttribute("user") @Valid UserRegistrationDTO userRegistrationDTO,
											BindingResult result,
											SessionStatus status) {
		
		UserRegistrationValidator userRegValidator = new UserRegistrationValidator();
		result = userRegValidator.validate(userService, userRegistrationDTO, result);
		
		// DOB validation
		if(StringUtils.isNotBlank(userRegistrationDTO.getDob())) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dateOfBirth = formatter.parse(userRegistrationDTO.getDob());
				userRegistrationDTO.setDob(formatter.format(dateOfBirth));
				userRegistrationDTO.setDateOfBirth(dateOfBirth);
			} catch (ParseException e) {
				result.rejectValue("dob","error.dob.invalid");
			}
		} else {
			result.rejectValue("dob","error.dob.empty");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		if(!result.hasErrors()) {
			userService.save(userRegistrationDTO);
			
			modelAndView.addObject("registrationSuccess", "true"); // registrationSuccess will be sent as parameter not property
			modelAndView.setViewName("redirect:/myLogin");
			
			// The above approach is same as below commented line
			//modelAndView.setViewName("redirect:/myLogin?registrationSuccess=true");
			
		} else {
			modelAndView = initRegistration(userRegistrationDTO);
		}
		return modelAndView;
	}
	
}
