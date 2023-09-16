package com.example.LoanApplication.services;

import java.util.List; 
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.entities.CustomerRole;
import com.example.LoanApplication.helper.UserFoundException;
import com.example.LoanApplication.repository.CustomerRepository;
import com.example.LoanApplication.repository.RoleRepository;

@Service
public class CustomerServiceImp implements CustomerServices {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	
	// creating customer	
	@Override
	public Customer createCustomer(Customer customer, Set<CustomerRole> customerRoles) throws Exception {

		Customer local = this.customerRepository.findByUsername(customer.getUsername());
		if (local != null) {
			System.out.println("User is already there..");
			throw new UserFoundException();
		} else {

			// customer create
			for (CustomerRole ur : customerRoles) {
				roleRepository.save(ur.getRole());
			}

			customer.getCustomerRoles().addAll(customerRoles);
			local = this.customerRepository.save(customer);

		}
		return local;

	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(Long id) {
		customerRepository.deleteById(id);
	}
}
