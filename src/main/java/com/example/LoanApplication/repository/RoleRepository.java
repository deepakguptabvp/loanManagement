package com.example.LoanApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LoanApplication.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {
 
}
