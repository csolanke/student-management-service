package com.cds.org.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cds.org.student.management.system.model.Employee;
import com.cds.org.student.management.system.repository.EmployeeRepository;

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

}
