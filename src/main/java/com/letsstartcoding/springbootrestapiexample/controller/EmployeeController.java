package com.letsstartcoding.springbootrestapiexample.controller;


import java.util.List;



import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

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
	public Employee createEmployee(@Validated @RequestBody Employee emp) {
		return employeeDAO.saveEmployee(emp);
		
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
		
	}
	/*get employee by empid*/
	
		
		
	}
	
	
