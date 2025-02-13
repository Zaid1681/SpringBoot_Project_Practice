package com.zaid.example.Customer.Service;

import java.util.List;

import com.zaid.example.Customer.Entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomerById(Long id);

	Customer addCustomer(Customer customer);

	Customer updateCustomerById(Customer customer, Long id);

	void deleteCustomerById(Long id);

}
