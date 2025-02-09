package com.example.zaid.EmployeeCRUD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zaid.EmployeeCRUD.model.Employee;
import com.example.zaid.EmployeeCRUD.repository.EmployeeRepository;



@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository employeeRepo;

	//Autowiring in Spring is a feature that automatically
	//injects dependencies into a class
	//part of IOC
		
	// CRUD operations
	@PostMapping("/employees")
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return "employee created success";
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = new ArrayList<>();
		employeeRepo.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList , HttpStatus.OK);
	}
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long empId ) {
		Optional<Employee> emp = employeeRepo.findById(empId);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	
	
	
	
	
}
