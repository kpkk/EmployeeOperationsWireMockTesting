package com.org.employeeOperations.services;

import java.util.ArrayList;
import java.util.List;

import com.org.employeeOperations.entities.EmployeeModel;

public class EmployeeService {
	
	/*EmployeeModel empModel=new EmployeeModel(1, "Roger", "computer science");
	EmployeeModel empModel1=new EmployeeModel(2, "Rafa", "IT");
	EmployeeModel empModel2=new EmployeeModel(3, "Andy", "ECE");*/
	List<EmployeeModel> empList=new ArrayList<EmployeeModel>(); 
	
	public void logIn() {
		
		
	}
	
	public void logOut() {
		
	}
	
	public String saveEmployee(EmployeeModel employee) {
		empList.add(employee);
		return "Employee saved sccesfully";
		
		
	}
	
	public List<EmployeeModel> saveEmployeeList(List<EmployeeModel> employees) {
		empList.addAll(employees);
		return employees;
		
	}
	
	public List<EmployeeModel> getAllEmployees() {
		
	/*	EmployeeModel empModel=new EmployeeModel(1, "Roger", "computer science");
		EmployeeModel empModel1=new EmployeeModel(2, "Rafa", "IT");
		EmployeeModel empModel2=new EmployeeModel(3, "Andy", "ECE");
		List<EmployeeModel> lisemp=new ArrayList<EmployeeModel>();
		lisemp.add(empModel);
		lisemp.add(empModel1);
		lisemp.add(empModel2);
		return lisemp;
		*/
		
		return empList;
		
	}
	
	
	public EmployeeModel getEmployeeByName(String name) {
		
		EmployeeModel emp=null;
		/*EmployeeModel empModel=new EmployeeModel(1, "Roger", "computer science");
		EmployeeModel empModel1=new EmployeeModel(2, "Rafa", "IT");
		EmployeeModel empModel2=new EmployeeModel(3, "Andy", "ECE");
		List<EmployeeModel> lisemp=new ArrayList<EmployeeModel>();
		lisemp.add(empModel);
		lisemp.add(empModel1);
		lisemp.add(empModel2);*/
		
		for(EmployeeModel eachEmp: empList) {
			if((eachEmp.getEmployeeName()).equals(name)) {
				emp=eachEmp;
			
				break;
				
			}
				
		}
		
		//return new EmployeeModel(10,"pradeep","Engineering");
		return emp;
		
	}
	
	
	public EmployeeModel updateEmployeeByName(EmployeeModel e, String name) {
		EmployeeModel emp;
		for(EmployeeModel eachEmp: empList) {
			if((eachEmp.getEmployeeName()).equals(name)) {
			eachEmp=e;
				break;
				
			}
				
		}
		return e;
		
	}
	
	public String deleteEmployeeByName(String name) {
		//List<EmployeeModel> allEmployees = getAllEmployees();
		
		EmployeeModel emp;
		
		for(EmployeeModel eachEmp: empList) {
			if((eachEmp.getEmployeeName()).equals(name)) {
				System.out.println(empList.indexOf(eachEmp));
			empList.remove(empList.indexOf(eachEmp));
				break;
				
			}
				
		}		
		
	return "employee has succesfully been deleted";
	}

}
