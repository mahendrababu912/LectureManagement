package com.letsstartcoding.springbootrestapiexample.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@PostMapping("/employee")
	@PreAuthorize("hasRole('ROLE_ADMIN'.'ROLE_USER')")
	public Employee createEmployee( @RequestBody Employee emp) {
		return employeeDAO.save(emp);
		
	}
	@GetMapping("/employeesdetails")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
		
	}
	
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empid){
			
			Employee emp=employeeDAO.get(empid);
			
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(emp);
			
		}
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long empid, @RequestBody Employee empDetails){
			
			Employee emp=employeeDAO.get(empid);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setExpertise(empDetails.getExpertise());
			
			Employee updateEmployee=employeeDAO.save(emp);
			return ResponseEntity.ok().body(updateEmployee);
			
			
			
		}
			
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
			
			Employee emp=employeeDAO.get(empid);
			if(emp==null) {
				return ResponseEntity.notFound().build();
			}
			employeeDAO.delete(empid);
			
			return ResponseEntity.ok().build();
			
			
		}
	}
	

