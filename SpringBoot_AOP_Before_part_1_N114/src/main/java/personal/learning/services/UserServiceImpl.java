package personal.learning.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import personal.learning.model.dao.UserRepository;
import personal.learning.model.entity.Country;
import personal.learning.model.entity.Language;
import personal.learning.model.entity.Role;
import personal.learning.model.entity.Users;
import personal.learning.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService {
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> userOp = userRepository.getUserByUserName(username);
		User userDetails = null;
		if(userOp.isPresent()) {
			Users user = userOp.get();
			userDetails = new User(user.getUserName(), 
								   user.getPassword(), 
								   mapRolesToGrantedAuthorities(user.getListOfRoles()));
		}
		return userDetails;
	}
	
	public Collection<? extends GrantedAuthority> mapRolesToGrantedAuthorities(Collection<Role> roles) {
	    List<GrantedAuthority> grantedAuthorities = roles.stream()
	    										  .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
	    										  .collect(Collectors.toList());
		return grantedAuthorities;
	}
	
	@Override
	public void save(UserRegistrationDTO userRegistrationDTO) {
		Users user = new Users(userRegistrationDTO.getUsername(), passwordEncoder().encode(userRegistrationDTO.getPassword()));
		user.setEnabled('Y');
		user.setEmail(userRegistrationDTO.getEmail());
		user.setFirstName(userRegistrationDTO.getFirstName());
		user.setLastName(userRegistrationDTO.getLastName());
		user.setGender(userRegistrationDTO.getGender());
		user.setDob(userRegistrationDTO.getDateOfBirth());
		
		Optional<Country> countryOp = userRepository.getCountryByName(userRegistrationDTO.getCountry());
		if(countryOp.isPresent()) {
			user.setCountry(countryOp.get());
		}
		
		List<Language> listOfLang = new ArrayList<>();
		for(String lang : userRegistrationDTO.getListOfLang()) {
			Optional<Language> languageOp = userRepository.getLangByName(lang);
			if(languageOp.isPresent()) {
				listOfLang.add(languageOp.get());
			}
		}
		user.setListOfLang(listOfLang);
		
		List<Role> listOfRole = new ArrayList<>();
		for(String role : userRegistrationDTO.getListOfRole()) {
			Optional<Role> authorityOp = userRepository.getRoleByName(role);
			if(authorityOp.isPresent()) {
				Role authority = authorityOp.get();
				authority.setListOfUsers(null); // To avoid deadlock
				listOfRole.add(authority);
			}
		}
		user.setListOfRoles(listOfRole);
		
		user.setAddress(userRegistrationDTO.getAddress());
		
		userRepository.save(user);
	}

	@Override
	public LinkedHashMap<String, String> getCountryMap() {
		LinkedHashMap<String, String> countryCodeMap = new LinkedHashMap<>();
		List<Country> countryList = userRepository.getCountryList();
		for(Country country : countryList) {
			countryCodeMap.put(country.getCountryName(), country.getCountryFullName());
		}
		return countryCodeMap;
	}

	@Override
	public LinkedHashMap<String, String> getLangMap() {
		LinkedHashMap<String, String> langMap = new LinkedHashMap<>();
		List<Language> langList = userRepository.getLangList();
		for(Language lang : langList) {
			langMap.put(lang.getLangName(), lang.getLangName());
		}
		return langMap;
	}
	
	@Override
	public LinkedHashMap<String, String> getRoleMap() {
		LinkedHashMap<String, String> roleMap = new LinkedHashMap<>();
		List<Role> roleList = userRepository.getRoleList();
		for(Role role : roleList) {
			roleMap.put(role.getRoleName(), role.getRoleDisplayName());
		}
		return roleMap;
	}

	@Override
	public boolean isNewUsername(String username) {
		if(userRepository.getPkByUserName(username) == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isNewEmail(String email) {
		if(userRepository.getPkByEmail(email) == -1) {
			return true;
		}
		return false;
	}

	@Override
	public List<String> getCountryList() {
		List<Country> countryList = userRepository.getCountryList();
		List<String> countryNameList = countryList.stream()
												  .map(country -> country.getCountryName())
												  .collect(Collectors.toList());
		return countryNameList;
	}

	@Override
	public List<String> getLanguageList() {
		List<Language> langList = userRepository.getLangList();
		List<String> langNameList = langList.stream()
				  							   .map(lang -> lang.getLangName())
				  							   .collect(Collectors.toList());
		return langNameList;
	}

	@Override
	public List<String> getRoleList() {
		List<Role> roleList = userRepository.getRoleList();
		List<String> roleNameList = roleList.stream()
				  							   .map(lang -> lang.getRoleName())
				  							   .collect(Collectors.toList());
		return roleNameList;
	}
	
}
