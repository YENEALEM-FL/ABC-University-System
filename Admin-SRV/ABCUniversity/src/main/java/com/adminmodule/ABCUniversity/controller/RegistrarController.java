package com.adminmodule.ABCUniversity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminmodule.ABCUniversity.entity.Registrar;

import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.service.RegistrarService;

@RestController
public class RegistrarController {
	@Autowired
	RegistrarService registrarservice;
	
	@PostMapping("/registrars")
public Registrar add(@RequestBody Registrar registrar) {
		
	return registrarservice.add(registrar);
	
}
@GetMapping("/registrars")
	public List<Registrar> getAll(){
		return registrarservice.getAllRegistrar();
	}


@GetMapping("/registrars/{registrar_id}")
public Registrar getOne(@PathVariable int registrar_id) {
	Registrar theregistrar=registrarservice.getOne(registrar_id);
	if(theregistrar==null) {
		throw new AdminmoduleException(" id not found"+ registrar_id);
	}
	return theregistrar;
}

@DeleteMapping("/registrars/{registrar_id}")
public void deleteOne(@PathVariable int registrar_id) {
	Registrar registrar=registrarservice.getOne(registrar_id);
	if(registrar!=null) {
		registrarservice.deleteRegistrar(registrar_id);
	}
	else {
		throw new AdminmoduleException(registrar_id);
	}
	
}
	

@PutMapping("/registrars/{registrar_id}")
public Registrar updateOne(@PathVariable int registrar_id,@RequestBody Registrar registrar){

	registrarservice.updateRegistrar(registrar_id, registrar);

    Registrar registrar1 = registrarservice.getOne(registrar_id);
    return registrar1;
}

}



