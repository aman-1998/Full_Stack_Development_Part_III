package personal.learning.employee;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private String name;
	private int empId;
	private String designation;
	
	public Employee(String name, int empId, String designation) {
		this.name = name;
		this.empId = empId;
		this.designation = designation;
	}
	
	public Employee() {
		this.name = "####";
		this.empId = 0;
		this.designation = "####";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", designation=" + designation + "]";
	}
	
}
