package edu.miu.projectmanagement.registrationsrv.service;

import edu.miu.projectmanagement.registrationsrv.enums.Term;
import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Set;

public interface ICourseRegistrationService {
     ResponseEntity<String> courseRegistration(long id, Set<Course> courses, Term term);

}
