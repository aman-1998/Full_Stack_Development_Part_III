package personal.learning.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;


import org.apache.commons.lang3.StringUtils;

public class UserRegistrationDTO {
	
	@NotBlank(message="Username can't be empty")
	private String username = StringUtils.EMPTY;
	
	@NotBlank(message="Password can't be empty")
	private String password = StringUtils.EMPTY;
	
	@NotBlank(message="Email can't be empty")
	private String email = StringUtils.EMPTY;
	
	@NotBlank(message="First Name can't be empty")
	private String firstName = StringUtils.EMPTY;
	
	private String lastName = StringUtils.EMPTY;
	
	@NotBlank(message="Date of birth can't be empty")
	private String dob = StringUtils.EMPTY;
	
	private Date dateOfBirth = null;
	
	@NotBlank(message="Gender can't be empty")
	private String gender = StringUtils.EMPTY;
	
	@NotBlank(message="Country can't be empty")
	private String country = StringUtils.EMPTY;
	
	private String address;
	
	private List<String> listOfLang = new ArrayList<>();
	
	private List<String> listOfRole = new ArrayList<>();
	
	public void reset() {
		this.username = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.dob = StringUtils.EMPTY;
		this.dateOfBirth = null;
		this.gender = StringUtils.EMPTY;
		this.country = StringUtils.EMPTY;
		this.listOfLang = new ArrayList<>();
		this.listOfRole = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getListOfLang() {
		return listOfLang;
	}

	public void setListOfLang(List<String> listOfLang) {
		this.listOfLang = listOfLang;
	}

	public List<String> getListOfRole() {
		return listOfRole;
	}

	public void setListOfRole(List<String> listOfRole) {
		this.listOfRole = listOfRole;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
