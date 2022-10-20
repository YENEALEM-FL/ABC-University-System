package com.adminmodule.ABCUniversity.entity;

import javax.persistence.Entity;

import com.adminmodule.ABCUniversity.enumm.Role;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class Faculty extends User {



	public Faculty(String firstName, String lastName, String email, String password, Role role) {
		super(firstName, lastName, email, password, role);
		
	}
	

	
	
	
}
