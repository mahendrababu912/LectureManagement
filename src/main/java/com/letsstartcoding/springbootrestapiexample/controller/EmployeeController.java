package com.letsstartcoding.springbootrestapiexample.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.Entity.Employee;
import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	
	@PostMapping("/employees")
	public Employee createEmployee( @RequestBody Employee emp) {
		return employeeDAO.saveEmployee(emp);
		
	}
	@GetMapping("/employeesdetails")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
		
	}
	/*get employee by empid*/
	
		/*@GetMapping("/employees/{id}")
		public Employee getEmployeeById(@PathVariable(value="id" ) Long empid){
			return employeeDAO.findbyid(empid);
		
		}*/
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
			
			Employee emp=employeeDAO.findbyid(empid);
			
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);
			
		}
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Validated @RequestBody Employee empDetails){
			
			Employee emp=employeeDAO.findbyid(empid);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setExpertise(empDetails.getExpertise());
			
			Employee updateEmployee=employeeDAO.saveEmployee(emp);
			return ResponseEntity.ok().body(updateEmployee);
			
			
			
		}
			
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
			
			Employee emp=employeeDAO.findbyid(empid);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			employeeDAO.delete(emp);
			
			return ResponseEntity.ok().build();
			
			
		}
	}
	

