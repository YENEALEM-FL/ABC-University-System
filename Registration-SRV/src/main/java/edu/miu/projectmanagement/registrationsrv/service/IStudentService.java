package edu.miu.projectmanagement.registrationsrv.service;

import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IStudentService {

    ResponseEntity<Student> addStudent(Student student);

}
