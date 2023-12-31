package com.example.LoanApplication.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = this.customerRepository.findByUsername(username);
		if(customer == null ) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user found");
		}
		return customer;
	}

}

