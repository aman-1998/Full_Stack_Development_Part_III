package personal.learning.employee.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import personal.learning.employee.Employee;
import personal.learning.employee.repositories.EmployeeRepository;

@Path("/amazon")
public class EmployeeResource {

	EmployeeRepository empRepo = new EmployeeRepository();
	
	@GET
	@Path("/getEmployes")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmps() {
		return empRepo.getAllEmployes();
	}
	
	@GET
	@Path("/getEmployee/{brandId}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmp(@PathParam("brandId") int brandId) {
		return empRepo.getEmployee(brandId);
	}
	
	@POST
	@Path("/createEmployee")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> createEmp(Employee emp) {
		empRepo.createEmployee(emp);
		return empRepo.getAllEmployes();
	}
	
	@PUT
	@Path("/updateEmployee")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> updateEmp(Employee emp) {
		empRepo.updateEmployee(emp);
		return empRepo.getAllEmployes();
	}
	
	@DELETE
	@Path("/deleteEmployee/{brandId}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> deleteEmp(@PathParam("brandId") int brandId) {
		Employee emp = empRepo.getEmployee(brandId);
		empRepo.deleteEmployee(brandId);
		return empRepo.getAllEmployes();
	}
}
