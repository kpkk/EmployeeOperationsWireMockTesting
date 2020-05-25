package com.org.employeeOpertions;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.employeeOperations.entities.EmployeeModel;
import com.org.employeeOperations.services.EmployeeService;

@RestController()

public class EmployeeController {
	//@Autowired(required=true)
	EmployeeService employeeService=new EmployeeService();
	
	
	@GetMapping("/getEmployee/{name}")
	public EmployeeModel getEmployee(@PathVariable("name") String name) {
		return employeeService.getEmployeeByName(name);
		
	}
	
	@GetMapping("/getAllEmployees")
	public List<EmployeeModel> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
	@PostMapping("/employee")
	public String createEmployee(@RequestBody EmployeeModel employee) {
	//employee.setDepartment("");
		return employeeService.saveEmployee(employee);
		
			
	}
	
	@PostMapping("/employee/createWithArray")
	public List<EmployeeModel> createEmployeeList(@RequestBody List<EmployeeModel> employees) {
		return employeeService.saveEmployeeList(employees);
		
		
	}
	
	@PostMapping("/employee/{employeeName}")
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel employee, @PathVariable("name") String name) {
		
		return employeeService.updateEmployeeByName(employee, name);
		
		//return "";
		
	}
	
	@DeleteMapping("/deleteEmployee/{name}")
	public String deleteEmployee(@PathVariable("name") String name) {
		return employeeService.deleteEmployeeByName(name);
		
	}
	
	

}
