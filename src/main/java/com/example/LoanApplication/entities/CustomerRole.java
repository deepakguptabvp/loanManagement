package com.example.LoanApplication.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomerRole {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long customerRoleId;
	
	
	//	customer
	@ManyToOne(fetch =FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne()
	private Role role;
	
	public CustomerRole() {
		
	}

	public Long getCustomerRoleId() {
		return customerRoleId;
	}

	public void setCustomerRoleId(Long customerRoleId) {
		this.customerRoleId = customerRoleId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
