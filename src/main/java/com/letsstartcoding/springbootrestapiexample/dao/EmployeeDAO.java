package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;
import java.util.Optional;

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
	public Employee findbyid(Long empid) {
		/*Employee emp1= employeeReository.findById(empid);
		return emp1;
		*/
		Optional<Employee> optionalEmployee = employeeReository.findById(empid); // Assuming getEmployee() returns Optional<Employee>

	Employee employee=optionalEmployee.orElse(null);
	return employee;
	}
	
	
	//delete an employee
	public void delete(Employee emp) {
		
		
	employeeReository.delete(emp);
	
	
	
	}


}
