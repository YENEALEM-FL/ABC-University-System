package edu.miu.projectmanagement.registrationsrv.controller;
import edu.miu.projectmanagement.registrationsrv.enums.Term;
import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/")
public class CourseRegistrationController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ICourseRegistrationService courseRegistrationService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IEnrollmentService enrollmentService;
    @Autowired
    private IEmailSender emailSender;

    @PostMapping("registration/{id}/{term}")
    public ResponseEntity<String> courseRegistration(@PathVariable("id") long id, @PathVariable("term") Term term, @RequestBody Set<Course> courses){
        return courseRegistrationService.courseRegistration(id,courses, term);
    }

    @GetMapping("getRegisteredStudentsPerCourse/{id}/{term}/{dateInfo}")
    public ResponseEntity<Set<Student>> registeredStudentsPerCourse(@PathVariable("id") long id, @PathVariable("term") Term term, @PathVariable("dateInfo") LocalDate dateOfRegistration){
        return enrollmentService.registeredStudentsForACourse(id, term, dateOfRegistration);
    }

    @PostMapping("registerStudent/")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PostMapping("registerCourse/")
    public ResponseEntity<Course> registerCourse(@RequestBody Course course){
        return  courseService.addCourse(course);
    }


    @GetMapping("sendRegistrationConfirmation/{toEmail}")
    public ResponseEntity<String> sendRegistrationConfirmation( @PathVariable("toEmail") String toEmail){
        return  emailSender.sendEmail(toEmail);
    }

}
