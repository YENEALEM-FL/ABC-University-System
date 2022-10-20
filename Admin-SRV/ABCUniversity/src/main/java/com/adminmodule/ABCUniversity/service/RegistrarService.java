package com.adminmodule.ABCUniversity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminmodule.ABCUniversity.entity.Registrar;

import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.repository.RegistrarRepository;

@Service
public class RegistrarService {
	
	@Autowired
	RegistrarRepository registrarrepository;
	
	
	public Registrar add(Registrar registrar) {
		
		return registrarrepository.save(registrar);
	}
	
	public List<Registrar> getAllRegistrar(){
		return registrarrepository.findAll();
	}
	
	public Registrar getOne(long id) {
		if(!registrarrepository.findById(id).isEmpty()) {
		return registrarrepository.findById(id).get();
	}else {
		throw new AdminmoduleException(id);
	}
	}
	
	public Registrar deleteRegistrar(long id){
        if(!registrarrepository.findById(id).isEmpty()) {
            Registrar registrar = registrarrepository.findById(id).get();
            registrarrepository.deleteById(id);
            return registrar;
        }else{
            throw new AdminmoduleException(id);
        }
    }
	
	public Registrar updateRegistrar(long id, Registrar registrar){
        if(!registrarrepository.findById(id).isEmpty()) {
        	registrarrepository.save(registrar);
            Registrar registrar1 = registrarrepository.getReferenceById(id);
            return registrar1;
        }else{
            throw new AdminmoduleException(id);
        }
    }


}
