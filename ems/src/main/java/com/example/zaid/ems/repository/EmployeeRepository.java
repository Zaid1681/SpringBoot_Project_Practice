package com.example.zaid.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zaid.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long>{
	Optional<Employee> findByFirstNameIgnoreCase(String firstName);
}