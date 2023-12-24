package personal.learning.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import personal.learning.model.entity.Country;
import personal.learning.model.entity.Language;
import personal.learning.web.dto.UserRegistrationDTO;

public interface UserService extends UserDetailsService {
	
	void save(UserRegistrationDTO userRegistrationDTO);

	LinkedHashMap<String, String> getCountryMap();

	LinkedHashMap<String, String> getLangMap();

	boolean isNewEmail(String email);

	boolean isNewUsername(String username);

	List<String> getCountryList();

	List<String> getLanguageList();

	List<String> getRoleList();

	LinkedHashMap<String, String> getRoleMap();
	
}
