package personal.learning.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_generator")
	@SequenceGenerator(name="user_generator", sequenceName="USER_SEQUENCE", allocationSize=1)
	private int id;
	
	@Column(name="user_name", unique=true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="enabled")
	private char enabled;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="auth_status")
	private String authStatus;
	
	@Column(name="action_by")
	private String actionBy;
	
	@Column(name="address")
	private String address;
	
	//Uni-directional
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="country_id")
	private Country country;
	
	//Bi-directional
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="user_role",
			   joinColumns=@JoinColumn(name="user_id"),
			   inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> listOfRoles;
	
	//Uni-directional
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="user_lang",
			   joinColumns=@JoinColumn(name="user_id"),
			   inverseJoinColumns=@JoinColumn(name="lang_id"))
	private List<Language> listOfLang;
	
	public Users() {}
	
	public Users(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getListOfRoles() {
		return listOfRoles;
	}

	public void setListOfRoles(List<Role> listOfRoles) {
		this.listOfRoles = listOfRoles;
	}

	public List<Language> getListOfLang() {
		return listOfLang;
	}

	public void setListOfLang(List<Language> listOfLang) {
		this.listOfLang = listOfLang;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}
	
}
