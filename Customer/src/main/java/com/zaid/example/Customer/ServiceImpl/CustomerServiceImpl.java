package com.zaid.example.Customer.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaid.example.Customer.Entity.Customer;
import com.zaid.example.Customer.Exceptions.ResourceNotFoundException;
import com.zaid.example.Customer.Repository.CustomerRepository;
import com.zaid.example.Customer.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerRepo.findAll();
		if (customerList.isEmpty()) {
			throw new ResourceNotFoundException("Customer related data not found");
		} else {
			return customerList;
		}
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = customerRepo.findById(id).get();
//				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for the customer id " + id));
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		System.out.println("===>" + customer);
		Customer savedCustomer = customerRepo.save(customer);
		return savedCustomer;
	}

	@Override
	public Customer updateCustomerById(Customer customer, Long id) {
		Customer cust = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for the customer id " + id));
		cust.setcustomerName(customer.getcustomerName());
		cust.setAddress(customer.getAddress());
		cust.setEmail(customer.getEmail());
		cust.setPhoneNumber(customer.getPhoneNumber());
		Customer custSaved = customerRepo.save(cust);
		return custSaved;

	}

	@Override
	public void deleteCustomerById(Long id) {
		Customer cust = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for the customer id " + id));
		customerRepo.deleteById(id);
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getByEmail(String email) {
		Optional<Customer> cust = customerRepo.findByEmail(email);
		return cust.get();
	}

}
