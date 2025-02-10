package com.example.zaid.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zaid.ems.dto.EmployeeDto;
import com.example.zaid.ems.entity.Employee;
import com.example.zaid.ems.exception.ResourceNotFoundException;
import com.example.zaid.ems.mapper.EmployeeMapper;
import com.example.zaid.ems.repository.EmployeeRepository;
import com.example.zaid.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository; // without use of constructor in the below line it is taking it as a
													// null value

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee); // TODO Auto-generated method stub
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
//		handling optional response -1
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with EmployeeId: " + employeeId));
		;
		return EmployeeMapper.mapToEmployeeDto(employee);
//		handling optional response -2
//		Optional<Employee> employee = employeeRepository.findById(employeeId);
//		if(employee.isPresent()) {
//		    Employee emp = employee.get(); // Extract Employee from Optional
//			EmployeeDto empDto = EmployeeMapper.mapToEmployeeDto(emp);
//		    return empDto;
//		} else {
//			throw new ResourceNotFoundException("Employee not exist with EmployeeId: " + employeeId);
//		}

	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> empList = employeeRepository.findAll();
		if (empList.isEmpty()) {
			throw new ResourceNotFoundException("No Employee found in Database");
		}
		return empList.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());

	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto updateEmployee, Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee not exist with the given employee Id: " + id));
		emp.setEmail(updateEmployee.getEmail());
		emp.setFirstName(updateEmployee.getFirstName());
		emp.setLastName(updateEmployee.getLastName());
		Employee savedEmployee = employeeRepository.save(emp);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee not exist with the given employee Id: " + id));
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeDto findEmployeeByName(String firstName) {
		Employee emp = employeeRepository.findByFirstNameIgnoreCase(firstName)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Employee Name: " + firstName));
		;
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

}
