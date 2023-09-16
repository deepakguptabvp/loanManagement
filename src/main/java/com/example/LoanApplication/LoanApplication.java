package com.example.LoanApplication;

import java.util.*;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.entities.CustomerRole;
import com.example.LoanApplication.entities.Role;
import com.example.LoanApplication.helper.UserFoundException;
import com.example.LoanApplication.services.CustomerServices;

@SpringBootApplication
@CrossOrigin("*")
public class LoanApplication implements CommandLineRunner{

	@Autowired
	private CustomerServices customerServices;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return (WebMvcConfigurer) new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
		System.out.println("starting code");

		Customer customer = new Customer();

		customer.setFirst_name(" Nikhil");
		customer.setLast_name(" Mittal");
		customer.setUsername(" admin12");
//		customer.setPassword(this.bCryptPasswordEncoder.encode("admin12"));
		customer.setPassword("admin12");
		customer.setLoan_number((long) 12345); 
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");

		Set<CustomerRole> customerRoleSet = new HashSet<>();
		CustomerRole customerRole = new CustomerRole();
		customerRole.setRole(role1);
		customerRole.setCustomer(customer);

		customerRoleSet.add(customerRole);

		Customer customer1 = this.customerServices.createCustomer(customer, customerRoleSet);
		System.out.println(customer1.getUsername());
		
		} catch(UserFoundException e) {
			e.printStackTrace();
		}
	}
}
