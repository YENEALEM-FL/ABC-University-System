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

import com.adminmodule.ABCUniversity.entity.Faculty;
import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.service.FacultyService;

@RestController
public class FacultyController {
	@Autowired
	FacultyService facultyservice;
	
	

	@PostMapping("/faculties")
public Faculty add(@RequestBody Faculty faculty) {
		return facultyservice.add(faculty);
	
}
	@GetMapping("/faculties")
	public List<Faculty> getAll(){
		return facultyservice.getAll();
	}


@GetMapping("/faculties/{faculty_id}")
public Faculty getOne(@PathVariable long faculty_id) {
	Faculty faculty=facultyservice.getOne(faculty_id);
	if(faculty==null) {
		throw new AdminmoduleException("id not found"+ faculty_id);
	}
	return faculty;
}

@DeleteMapping("/faculties/{faculty_id}")
public void deleteOne(@PathVariable long faculty_id) {
	Faculty faculty=facultyservice.getOne(faculty_id);
	if(faculty!=null) {
		facultyservice.deleteOne(faculty_id);
	}
	else {
		throw new AdminmoduleException(faculty_id);
	}
	
}
	

@PutMapping("/faculties/{faculty_id}")
public Faculty updateOne(@PathVariable long faculty_id,@RequestBody Faculty faculty){

	facultyservice.updateOne(faculty_id, faculty);

	Faculty faculty1 = facultyservice.getOne(faculty_id);
    return faculty1;
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


