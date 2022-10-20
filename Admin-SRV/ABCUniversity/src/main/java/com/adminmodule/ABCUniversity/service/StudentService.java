package com.adminmodule.ABCUniversity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminmodule.ABCUniversity.entity.Student;
import com.adminmodule.ABCUniversity.exception.AdminmoduleException;
import com.adminmodule.ABCUniversity.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentrepository;
	
	
	public Student addOneStudent(Student student) {
	
		return studentrepository.save(student);
	}
	
	public List<Student> getAllStudent(){
		return studentrepository.findAll();
	}
	
	public Student getOneStudent(long id) {
		if(!studentrepository.findById(id).isEmpty()) {
		return studentrepository.findById(id).get();
	}else {
		throw new AdminmoduleException(id);
	}
	}
	
	public Student deleteOneStudent(long id){
        if(!studentrepository.findById(id).isEmpty()) {
            Student student = studentrepository.findById(id).get();
            studentrepository.deleteById(id);
            return student;
        }else{
            throw new AdminmoduleException(id);
        }
    }
	
	public Student updateOneStudent(long id, Student student){
        if(!studentrepository.findById(id).isEmpty()) {
            studentrepository.save(student);
            Student theStudent = studentrepository.getReferenceById(id);
            return theStudent;
        }else{
            throw new AdminmoduleException(id);
        }
    }

	
	

}
