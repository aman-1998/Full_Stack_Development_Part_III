package personal.learning.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORIZATION_RULE")
public class AuthorizationRule {
	
	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="rule_name", unique=true)
	public String ruleName;
	
	@Column(name="auth_required")
	public String authRequired;
	
	@Column(name="description")
	public String description;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getAuthRequired() {
		return authRequired;
	}
	
	public void setAuthRequired(String authRequired) {
		this.authRequired = authRequired;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
