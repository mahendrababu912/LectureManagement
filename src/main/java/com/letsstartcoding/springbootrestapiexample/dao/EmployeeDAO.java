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
	public Employee save(Employee emp) {
		return employeeReository.save(emp);
	}
	
	//search all employee
	
	
	public List<Employee> findAll(){
		return employeeReository.findAll();
	}
	public Employee get(Long id) {
		return employeeReository.findById(id).orElse(null);
	}
	
	//delete an employee
      public String delete(Long id) {
	 employeeReository.deleteById(id);
	 return ""+id;
	
    }
      
      public Employee update(Employee emp) {
    	  return employeeReository.findById(emp.getId()).orElse(null);
    	  
      }


}
