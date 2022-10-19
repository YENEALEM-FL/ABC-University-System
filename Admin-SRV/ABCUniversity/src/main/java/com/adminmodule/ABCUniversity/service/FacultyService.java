package com.adminmodule.ABCUniversity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminmodule.ABCUniversity.entity.Faculty;
import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.repository.FacultyRepository;

@Service
public class FacultyService {
@Autowired
	FacultyRepository facultyrepository;
	
	
	public Faculty add(Faculty faculty) {
		return  facultyrepository.save(faculty);
	}
	
	
	public List<Faculty> getAll(){
		return facultyrepository.findAll();
	}
	
	public Faculty getOne(long id) {
		if(!facultyrepository.findById(id).isEmpty()) {
		return facultyrepository.findById(id).get();
	}else {
		throw new AdminmoduleException(id);
	}
	}
	
	public Faculty deleteOne(long id){
        if(!facultyrepository.findById(id).isEmpty()) {
        	Faculty faculty = facultyrepository.findById(id).get();
        	facultyrepository.deleteById(id);
            return faculty;
        }else{
            throw new AdminmoduleException(id);
        }
    }
	
	public Faculty updateOne(long id, Faculty faculty){
        if(!facultyrepository.findById(id).isEmpty()) {
        	facultyrepository.save(faculty);
            Faculty faculty1 = facultyrepository.getReferenceById(id);
            return faculty1;
        }else{
            throw new AdminmoduleException(id);
        }
    }

	
	

}

	
	
	
	
	
	
	
	
	
	
	

