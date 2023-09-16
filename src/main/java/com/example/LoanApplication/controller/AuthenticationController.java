package com.example.LoanApplication.controller;

import java.security.Principal; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoanApplication.config.JwtUtil;
import com.example.LoanApplication.entities.Customer;
import com.example.LoanApplication.entities.JwtRequest;
import com.example.LoanApplication.entities.JwtResponse;
import com.example.LoanApplication.helper.UserNotFoundException;
import com.example.LoanApplication.services.UserDetailsServiceImpl;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//generate-token
	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
			
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}

		//authenticate
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception ("USER DISABLED" + e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception ("Invalid Credentials " + e.getMessage());
		}
	}
	
	// return details of current customer.	
	@GetMapping("/current-customer")
	public Customer getCurrentCustomer(Principal principal) {
		return ((Customer)this.userDetailsService.loadUserByUsername(principal.getName()));
	}		
}
