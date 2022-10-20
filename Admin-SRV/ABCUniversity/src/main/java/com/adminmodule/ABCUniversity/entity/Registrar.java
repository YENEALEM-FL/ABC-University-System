package com.adminmodule.ABCUniversity.entity;

import javax.persistence.Entity;

import com.adminmodule.ABCUniversity.enumm.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class Registrar extends User{

	public Registrar(String firstName, String lastName, String email, String password, Role role) {
		super(firstName, lastName, email, password, role);
		
	}

	
	
	
	
	
}
