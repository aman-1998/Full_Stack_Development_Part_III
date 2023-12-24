package personal.learning.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCHOOL")
public class School {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="school_name", unique=true)
	private String schoolName;
	
	@Column(name="board_full_name")
	private String boardFullName;
	
	@Column(name="board_short_name")
	private String boardShortName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="type")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getBoardFullName() {
		return boardFullName;
	}

	public void setBoardFullName(String boardFullName) {
		this.boardFullName = boardFullName;
	}

	public String getBoardShortName() {
		return boardShortName;
	}

	public void setBoardShortName(String boardShortName) {
		this.boardShortName = boardShortName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
