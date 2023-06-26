package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.Entity.Employee;
import com.letsstartcoding.springbootrestapiexample.repository.EmployeeRepository;
@Service
public class EmployeeDAO {
	@Autowired
	private EmployeeRepository employeeReository;
	
	//to save an employee
	public Employee saveEmployee(Employee emp) {
		return employeeReository.save(emp);
	}
	
	//search all employee
	
	
	public List<Employee> findAll(){
		return employeeReository.findAll();
	}
	//update an employee
	
	
	
	//delete an employee
	public void delete(Employee emp) {
		employeeReository.delete(emp);
	}


}
