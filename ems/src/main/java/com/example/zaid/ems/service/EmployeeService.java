package com.example.zaid.ems.service;


import java.util.List;

import com.example.zaid.ems.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployee();
	EmployeeDto updateEmployee(EmployeeDto updateEmployee , Long id);
	void deleteEmployeeById( Long id);
}
