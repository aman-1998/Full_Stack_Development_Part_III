package personal.learning.web.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;

import personal.learning.services.UserService;
import personal.learning.web.dto.UserRegistrationDTO;

public class UserRegistrationValidator {
	
	public BindingResult validate(UserService userService, UserRegistrationDTO user, BindingResult result) {
		
		// Username validation
		if(StringUtils.isBlank(user.getUsername())) {
			result.rejectValue("username", "error.username.empty");
			
		} else {
			String regex = "^[a-zA-Z0-9_.-]*$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getUsername());
			boolean isValidUsername = matcher.matches();
			if(!isValidUsername) {
				result.rejectValue("username","error.username.invalid");
			}
			
			boolean isNewUsername = userService.isNewUsername(user.getUsername());
			if(!isNewUsername) {
				result.rejectValue("username", "error.username.duplicate");
			}
		}
		
		// Password validation
		if(StringUtils.isBlank(user.getPassword())) {
			result.rejectValue("password", "error.password.empty");
		} else {
			/*
			 * 	^ represents starting character of the string.
			 *	(?=.*[0-9]) represents a digit must occur at least once.
			 *	(?=.*[a-z]) represents a lower case alphabet must occur at least once.
			 *	(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
			 *	(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
			 *	(?=\\S+$) white spaces don’t allowed in the entire string.
			 *	.{8, 20} represents at least 8 characters and at most 20 characters.
			 *	$ represents the end of the string.
			 */
			String regex = "^(?=.*[0-9])"
		                    + "(?=.*[a-z])"
							+ "(?=.*[A-Z])"
		                    + "(?=.*[@#$%^&+=])"
		                    + "(?=\\S+$)"
		                    + ".{8,20}$";
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getPassword());
			boolean isValidPassword = matcher.matches();
			if(!isValidPassword) {
				result.rejectValue("password","error.password.invalid");
			}
		}
		
		// Email validation
		if(StringUtils.isBlank(user.getEmail())) {
			result.rejectValue("email", "error.email.empty");
			
		} else {
			String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getEmail());
			boolean isValidEmail = matcher.matches();
			if(!isValidEmail) {
				result.rejectValue("email", "error.email.invalid");
			} else {
				boolean isNewEmail = userService.isNewEmail(user.getEmail());
				if(!isNewEmail) {
					result.rejectValue("email", "error.email.duplicate");
				}
			}
		}
		
		// Gender validation
		if(StringUtils.isNotBlank(user.getGender())) {
			if(!StringUtils.equalsIgnoreCase(user.getGender(), "Male") && !StringUtils.equalsIgnoreCase(user.getGender(), "Female")) {
				result.rejectValue("gender", "error.gender.invalid");
			}
		} else {
			result.rejectValue("gender", "error.gender.empty");
		}
		
		// Country Validation
		if(StringUtils.isNotBlank(user.getCountry())) {
			List<String> validCountryList = userService.getCountryList();
			if(!validCountryList.contains(user.getCountry())) {
				result.rejectValue("country", "error.country.invalid");
			}
		} else {
			result.rejectValue("country", "error.country.empty");
		}
		
		// Language Validation
		if(!user.getListOfLang().isEmpty()) {
			List<String> validLangList = userService.getLanguageList();
			if(!validLangList.containsAll(user.getListOfLang())) {
				result.rejectValue("listOfLang", "error.lang.invalid");
			}
		} else {
			result.rejectValue("listOfLang", "error.lang.empty");
		}
		
		// Role Validation
//		if(!user.getListOfRole().isEmpty()) {
//			List<String> validRoleList = userService.getRoleList();
//			if(!validRoleList.containsAll(user.getListOfRole())) {
//				result.rejectValue("listOfRole", "error.role.invalid");
//			}
//		} else {
//			result.rejectValue("listOfRole", "error.role.empty");
//		}
		
		return result;
	}
}
