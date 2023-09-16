package com.example.LoanApplication.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.entities.CustomerRole;

public interface CustomerServices {
	
//	find all
	public List<Customer> findAll();
	
//	find by Id
	public	Optional<Customer> findById(Long id);
	
//	Save
	public	Customer save(Customer customer);
	
// delete
	 public	void delete(Long id);

	Customer createCustomer(Customer customer, Set<CustomerRole> customerRoles) throws Exception;
	
}
