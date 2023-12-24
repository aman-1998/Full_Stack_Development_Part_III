package personal.learning.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LANGUAGE")
public class Language {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="lang_name", unique=true)
	private String langName;
	
	public Language() { }
	
	public Language(String langName) {
		this.langName = langName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}
	
}
