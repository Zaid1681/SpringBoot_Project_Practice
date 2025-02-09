package com.example.zaid.EmployeeCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zaid.EmployeeCRUD.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee , Long >{

}
