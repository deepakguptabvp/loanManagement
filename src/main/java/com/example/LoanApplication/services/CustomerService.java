//package services;
//package com.example.LoanApplication.services;
//
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Service;
//
//import com.example.LoanApplication.entities.Customer;
//import com.example.LoanApplication.repository.CustomerRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CustomerService {
//
//	@Autowired
//	private CustomerRepository customerRepository; 
//	
//	 public List<Customer> findAll() {
//	        return customerRepository.findAll();
//	    }
//
//	    public Optional<Customer> findById(Long id) {
//	        return customerRepository.findById(id);
//	    }
//
//	    public Customer save(Customer customer) {
//	        return customerRepository.save(customer);
//	    }
//
//	    public void delete(Long id) {
//	    	customerRepository.deleteById(id);
//	    }
//	
//	   
//}
