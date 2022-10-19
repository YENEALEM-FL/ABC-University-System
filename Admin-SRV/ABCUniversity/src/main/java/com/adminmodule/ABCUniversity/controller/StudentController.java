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

import com.adminmodule.ABCUniversity.entity.Student;
import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	
	
	
	@PostMapping("/students")
public Student addOne(@RequestBody Student student) {
	return studentservice.addOneStudent(student);
	
}
@GetMapping("/students")
	public List<Student> getAll(){
		return studentservice.getAllStudent();
	}


@GetMapping("/students/{student_id}")
public Student getOne(@PathVariable long student_id) {
	Student theStudent=studentservice.getOneStudent(student_id);
	if(theStudent==null) {
		throw new AdminmoduleException("student id not found"+ student_id);
	}
	return theStudent;
}

@DeleteMapping("/students/{student_id}")
public void deleteOne(@PathVariable long student_id) {
	Student student=studentservice.getOneStudent(student_id);
	if(student!=null) {
	studentservice.deleteOneStudent(student_id);
	}
	else {
		throw new AdminmoduleException(student_id);
	}
	
}
	

@PutMapping("/students/{student_id}")
public Student updateOne(@PathVariable long student_id,@RequestBody Student student){

        studentservice.updateOneStudent(student_id, student);

    Student theStudent = studentservice.getOneStudent(student_id);
    return theStudent;
}
	
}
