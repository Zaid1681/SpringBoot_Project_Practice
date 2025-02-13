package com.zaid.example.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaid.example.Customer.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//	Optional<Employee> findByFirstNameIgnoreCase(String firstName);

}
