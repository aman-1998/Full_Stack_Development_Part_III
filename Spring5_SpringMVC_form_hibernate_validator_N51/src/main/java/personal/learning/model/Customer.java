package personal.learning.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	@NotBlank(message = "Name is a required field")
	private String name;

	@NotEmpty(message = "Date of birth must be specified")
	private String dob;
	
	private Date dateOfBirth;
	
	@NotEmpty(message = "Gender must be selected")
	@Pattern(regexp = "MALE|FEMALE", message = "Invalid gender")
	private String gender;
	
	@NotEmpty(message = "Country must be selected")
	private String country;
	
	@Size(min=1, max=4, message = "At least one language must be selected")
	private String[] language;
	
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
