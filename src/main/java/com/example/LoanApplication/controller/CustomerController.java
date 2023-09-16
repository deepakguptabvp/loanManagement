package com.example.LoanApplication.controller;

import java.util.HashSet; 
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.entities.CustomerRole;
import com.example.LoanApplication.entities.Role;
import com.example.LoanApplication.services.CustomerServices;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping(value = "/api/customer", produces = "application/json")

public class CustomerController {
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public CustomerController(CustomerServices customerServices) { // Constructor Injection
		this.customerServices = customerServices;
	}

	// Get all the Customer Details
	@GetMapping()
	public ResponseEntity<List<Customer>> getAllCustomer() {
		// System.out.println("Message: " + message);
		return ResponseEntity.ok(customerServices.findAll());
	}

	// Get Customer Details based on its ID
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
		Optional<Customer> customer = customerServices.findById(id);

		if (!customer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer.get());
	}

	// Insert new Customer Details in DB..
	@PostMapping()
	public Customer createCustomer(@RequestBody Customer customer) throws Exception {
		
		// encoding password with bcryptpasswordencoder
		customer.setPassword(this.bCryptPasswordEncoder.encode(customer.getPassword()));	
		
		Set<CustomerRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		CustomerRole customerRole = new CustomerRole();
		customerRole.setCustomer(customer);
		customerRole.setRole(role);
		
		roles.add(customerRole);
		
		return this.customerServices.createCustomer(customer, roles);
	}
	
	
//	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//		Customer savedCustomer = customerServices.save(customer);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedCustomer.getId()).toUri();
//
//		return ResponseEntity.created(location).body(savedCustomer);
//	}

	
	// Update an existing Customer Details based on its ID
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		Optional<Customer> optionalCustomer = customerServices.findById(id);

		if (!optionalCustomer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		customer.setId(id);
		customer = customerServices.save(customer);
		return ResponseEntity.ok(customer);
	}

	// Delete an existing Customer Details based on its ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
		customerServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
//	@ExceptionHandler(UserFoundException.class)
//	public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
//		return ResponseEntity<T>
//	}

}
