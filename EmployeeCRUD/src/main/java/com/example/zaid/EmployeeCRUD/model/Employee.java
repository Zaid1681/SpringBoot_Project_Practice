package com.example.zaid.EmployeeCRUD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employee_id;
	@Column(name = "emp_name")
	private String emp_name;	
	@Column(name = "emp_Add")
	private String emp_Add;
	@Column(name = "emp_salary")
	private float emp_salary;
	
	public Long getemployee_id() {
		return employee_id;
	}
	public void setemployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_Add() {
		return emp_Add;
	}
	public void setEmp_Add(String emp_Add) {
		this.emp_Add = emp_Add;
	}
	public float getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(float emp_salary) {
		this.emp_salary = emp_salary;
	}
	public Employee(Long employee_id, String emp_name, String emp_Add, float emp_salary) {
		super();
		this.employee_id = employee_id;
		this.emp_name = emp_name;
		this.emp_Add = emp_Add;
		this.emp_salary = emp_salary;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", emp_name=" + emp_name + ", emp_Add=" + emp_Add
				+ ", emp_salary=" + emp_salary + "]";
	}
	public Employee() {
		
	}
		
}


//
//CREATE TABLE Employee (
//    employee_id int,
//    emp_name varchar(255) Default null,
//    emp_Add varchar(255) Default null,
//    emp_salary float Default null
//);