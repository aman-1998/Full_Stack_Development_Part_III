package personal.learning.employee.repositories;

import java.util.ArrayList;
import java.util.List;

import personal.learning.employee.Employee;

public class EmployeeRepository {
	
	private List<Employee> empList = new ArrayList<Employee>();
	
	public EmployeeRepository() {
		Employee emp1 = new Employee("Aman Mishra", 10456, "Software Developer");
		Employee emp2 = new Employee("Utkarsh Mittal", 10573, "Bussiness Analyst");
		Employee emp3 = new Employee("Namita Patel", 10732, "Service Delivery Manager");
		Employee emp4 = new Employee("Yamini Pathak", 10021, "Vice President");
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
	}
	
	public List<Employee> getAllEmployes(){
		return empList;
	}
	
	public Employee getEmployee(int empId) {
		Employee emp = new Employee();
		if(!empList.isEmpty()) {
			for(Employee tempEmp : empList) {
				if(tempEmp.getEmpId() == empId) {
					emp = tempEmp;
					break;
				}
			}
		}
		return emp;
	}
	
	public boolean createEmployee(Employee emp) {
		if(emp == null) {
			return false;
		}
		empList.add(emp);
		return true;
	}
	
	public boolean updateEmployee(Employee emp) {
		boolean flag = false;
		if(!empList.isEmpty() && emp != null) {
			for(int i = 0; i <= empList.size()-1; i++) {
				if(empList.get(i).getEmpId() == emp.getEmpId()) {
					empList.get(i).setName(emp.getName());
					empList.get(i).setDesignation(emp.getDesignation());
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		if(!empList.isEmpty()) {
			for(int i = 0; i <= empList.size()-1; i++) {
				if(empList.get(i).getEmpId() == empId) {
					empList.remove(i);
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
