package com.example.LoanApplication.entities;

import java.util.*; 
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private Long roleId;
	private String roleName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<CustomerRole> customerRoles = new HashSet<>();


	public Role() {
	}
	
	public Set<CustomerRole> getCustomerRoles() {
		return customerRoles;
	}

	public void setCustomerRoles(Set<CustomerRole> customerRoles) {
		this.customerRoles = customerRoles;
	}

	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
