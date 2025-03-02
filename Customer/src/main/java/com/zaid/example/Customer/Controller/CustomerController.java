package com.zaid.example.Customer.Controller;

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

import com.zaid.example.Customer.Entity.Customer;
import com.zaid.example.Customer.Exceptions.ResourceNotFoundException;
import com.zaid.example.Customer.Service.CustomerService;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/add")
	ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
//		try {
		Customer custResponse = customerService.addCustomer(customer);
		return ResponseEntity.ok(custResponse);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
//		}
	}

	@GetMapping("/")
	ResponseEntity<?> getAllCustomers() {

//		try {
		List<Customer> customerList = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.FOUND);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
//		}
	}

	@GetMapping("/{id}")
	ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {

//		try {
		Customer customerList = customerService.getCustomerById(id);
		return new ResponseEntity<>(customerList, HttpStatus.FOUND);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
//		}
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long id) {

//		try {
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>("Customer Deleted Success", HttpStatus.FOUND);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
//		}
	}

	@PutMapping("/{id}")
	ResponseEntity<?> updateCustomerById(@PathVariable("id") Long id, @RequestBody Customer customer) {

//		try {
		Customer customerResp = customerService.updateCustomerById(customer, id);
		return new ResponseEntity<>(customerResp, HttpStatus.OK);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
//		}
	}

	@GetMapping("/getByEmail/{email}")
	ResponseEntity<?> getDetailsByEmail(@PathVariable("email") String email) {
		Customer customer = customerService.getByEmail(email);
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
}
