package personal.learning.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotBlank(message = "Name is a required field")
	private String name;
	
	private String email;
	
	@NotEmpty(message = "Date of birth must be specified")
	private String dob;
	
	private Date dateOfBirth;
	
	@NotEmpty(message = "Gender must be selected")
	@Pattern(regexp = "MALE|FEMALE", message = "Invalid gender")
	private String gender;
	
	@NotEmpty(message = "Country must be selected")
	private String country;
	
	private String countryName;
	
	@Size(min=1, max=4, message = "At least one language must be selected")
	private String[] language;
	
	private String address;
	
	public Customer(String cusEmail, String cusName, String cusGender, 
					Date cusDateOfBirth, String cusDob, String cusCountry, 
					String cusCountryName, String[] cusLang, String cusAddress) {
		email = cusEmail;
		name = cusName;
		gender = cusGender;
		dateOfBirth = cusDateOfBirth;
		dob = cusDob;
		country = cusCountry;
		countryName = cusCountryName;
		language = cusLang;
		address = cusAddress;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String[] getLanguage() {
		return language;
	}
	public void setLanguage(String[] language) {
		this.language = language;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
