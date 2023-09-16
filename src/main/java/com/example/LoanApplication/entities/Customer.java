package com.example.LoanApplication.entities;

import java.util.Collection; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements UserDetails {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String first_name;
	private String last_name;
	private Long loan_number;
	private String password;

	// customer many roles
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	@JsonIgnore
	private Set<CustomerRole> customerRoles = new HashSet<>();

	public Customer() {
	}

	public Set<CustomerRole> getCustomerRoles() {
		return customerRoles;
	}

	public void setCustomerRoles(Set<CustomerRole> customerRoles) {
		this.customerRoles = customerRoles;
	}

	public Customer(Long id, String username, String first_name, String last_name, Long loan_number, String password) {
		
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.loan_number = loan_number;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getLoan_number() {
		return loan_number;
	}

	public void setLoan_number(Long loan_number) {
		this.loan_number = loan_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", first_name=" + first_name + ", last_name="
				+ last_name + ", loan_number=" + loan_number + ", password=" + password + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();
		this.customerRoles.forEach(customerRole -> {
			set.add(new Authority(customerRole.getRole().getRoleName()));
			});
		return set;
	}
	
	
//	public String getPassword1() {
//		return password;
//	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}








//	    public Customer() {
//			
//		}
//
//		public Long getId( ) {
//	    	return id;
//	    }
//	    
//	    public void setId(Long id) {
//	        this.id = id;
//	    }
//	    
//		public String getUsername() {
//			return username;
//		}
//
//		public void setUsername(String username) {
//			this.username = username;
//		}
//	    
//	    public String getFirst_Name() {
//	        return first_name;
//	    }
//
//	    public void setFirst_Name(String first_name) {
//	        this.first_name = first_name;
//	    }
//	    
//	    public String getLast_Name() {
//	        return last_name;
//	    }
//
//	    public void setLast_Name(String last_name) {
//	        this.last_name = last_name;
//	    }
//	    
//	    public Long getLoan_number( ) {
//	    	return loan_number;
//	    }
//	    
//	    public void setLoan_number(Long loan_number) {
//	        this.loan_number = loan_number;
//	    }
//	    	
//	    public String getPass() {
//	        return pass;
//	    }
//
//	    public void setPass(String pass) {
//	        this.pass = pass;
//	    }

//		public int getDesiredLoanAmount() {
//			return 0;
//		}
//
//
//		public String getEmploymentType() {
//			return null;
//		}
//
//
//		public int getMonthlyIncome() {
//			return 0;
//		}

//}
