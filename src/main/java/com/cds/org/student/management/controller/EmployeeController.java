package com.cds.org.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cds.org.student.management.system.exception.ResourceNotFoundException;
import com.cds.org.student.management.system.model.Employee;
import com.cds.org.student.management.system.repository.EmployeeRepository;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	//get All Employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	
	//Add new Employee
	
	@PostMapping("/employees")
   public Employee addEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
			
		}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id)
	{
		Employee employee = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with requested not present"));
		return ResponseEntity.ok(employee);
		
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployees(@PathVariable Long id , @RequestBody Employee employee)
	{
		Employee emp = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with requested not present"));
	
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		
		repository.save(emp);
		
		return ResponseEntity.ok(emp);
	}
	

}
