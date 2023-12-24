package personal.learning.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
	
	@Id
	@Column(name="ID")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_generator")
	//@SequenceGenerator(name="role_generator", sequenceName="role_sequence", allocationSize=1)
	private int id;
	
	@Column(name="ROLE_NAME", unique=true)
	private String roleName;
	
	@Column(name="ROLE_DISPLAY_NAME")
	private String roleDisplayName;
	
	//Bi-directional
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="USER_ROLE",
			   joinColumns=@JoinColumn(name="ROLE_ID"),
			   inverseJoinColumns=@JoinColumn(name="USER_ID"))
	private List<Users> listOfUsers;
	
	public Role() {}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Users> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<Users> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public String getRoleDisplayName() {
		return roleDisplayName;
	}

	public void setRoleDisplayName(String roleDisplayName) {
		this.roleDisplayName = roleDisplayName;
	}
	
}
