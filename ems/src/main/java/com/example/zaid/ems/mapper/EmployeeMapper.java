package com.example.zaid.ems.mapper;

import com.example.zaid.ems.dto.EmployeeDto;
import com.example.zaid.ems.entity.Employee;

public class EmployeeMapper {
	// class to map employee to employeeDTO
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

	// Class to map employeeDto to Employee
	public static Employee mapToEmployee(EmployeeDto employeedto) {
		return new Employee(employeedto.getId(), employeedto.getFirstName(), employeedto.getLastName(),
				employeedto.getEmail());
	}

}
