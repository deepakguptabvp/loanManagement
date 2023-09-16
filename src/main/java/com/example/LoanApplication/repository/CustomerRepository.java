package com.example.LoanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;    
import org.springframework.stereotype.Repository;

import com.example.LoanApplication.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByUsername(String username);

}
