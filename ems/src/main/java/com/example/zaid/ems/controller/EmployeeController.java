package com.example.zaid.ems.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zaid.ems.dto.EmployeeDto;
import com.example.zaid.ems.exception.ResourceNotFoundException;
import com.example.zaid.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long EmpId) {
//		EmployeeDto emp = employeeService.getEmployeeById(EmpId);
//		return ResponseEntity.ok(emp); // recommended static method
//		return new ResponseEntity<>(emp , HttpStatus.FOUND); // more concise

		try {
			EmployeeDto emp = employeeService.getEmployeeById(EmpId);
			return ResponseEntity.ok(emp); // 200 OK
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage())); // Returning JSON
																										// error
																										// response
		}
	}

	// Rest controller to get all employees
	@GetMapping({ "/", "" })
	public ResponseEntity<?> getAllEmployee() {
		try {
			List<EmployeeDto> empDtoList = employeeService.getAllEmployee();
			return new ResponseEntity<List<EmployeeDto>>(empDtoList, HttpStatus.FOUND);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
		}
	}

	// Rest controller to update employee details
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable("id") Long Id, @RequestBody EmployeeDto updateEmployee) {
		try {
			EmployeeDto emp = employeeService.updateEmployee(updateEmployee, Id);
//			return ResponseEntity.ok(emp);
			return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
		}
	}

	// rest controller to delete employee
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long empId) {
		try {
			employeeService.deleteEmployeeById(empId);
			return ResponseEntity.ok("Employee Deleted Success");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
		}
	}

	@GetMapping("/firstName/{firstName}")
	public ResponseEntity<?> findByEmployeeName(@PathVariable("firstName") String firstName) {
		try {
			EmployeeDto employee = employeeService.findEmployeeByName(firstName);
			return new ResponseEntity<>(employee , HttpStatus.FOUND);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
		}
	}
}

/*
 * why use ResponseEntity<?>? it provide flexibility either success resp →
 * ResponseEntity<EmployeeDto> or Error response → ResponseEntity<Map<String,
 * String>>
 * 
 * 
 */
