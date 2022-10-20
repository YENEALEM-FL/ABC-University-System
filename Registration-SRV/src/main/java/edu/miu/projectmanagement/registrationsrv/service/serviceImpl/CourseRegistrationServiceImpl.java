package edu.miu.projectmanagement.registrationsrv.service.serviceImpl;

import edu.miu.projectmanagement.registrationsrv.enums.Term;
import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Enrollment;
import edu.miu.projectmanagement.registrationsrv.model.EnrollmentId;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.repository.CourseRepository;
import edu.miu.projectmanagement.registrationsrv.repository.EnrollmentRepository;
import edu.miu.projectmanagement.registrationsrv.repository.StudentRepository;
import edu.miu.projectmanagement.registrationsrv.service.ICourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;

@Transactional
@Service
public class CourseRegistrationServiceImpl implements ICourseRegistrationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ResponseEntity<String> courseRegistration(long id, Set<Course> courses, Term term) {

        Student student = studentRepository.findById(id).orElse(null);

        int today = LocalDate.now().getYear();
        EnrollmentId enrollmentId = new EnrollmentId(term,today);

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId).orElse(null);

        if(student != null && enrollment!=null){
            Set<Course> previousCourses = student.getCourses();
            previousCourses.addAll(courses);
            student.setCourses(previousCourses);

            Set<Enrollment> previousEnrollments = student.getEnrollments();
            previousEnrollments.add(enrollment);
            student.setEnrollments(previousEnrollments);

            studentRepository.save(student);
            courseRepository.saveAll(courses);
            enrollment.setCourses(courses);
            Set<Student> students = enrollment.getStudents();
            students.add(student);
            enrollment.setStudents(students);
            enrollmentRepository.save(enrollment);
            return ResponseEntity.ok(student.getFirstName() +" "+ student.getLastName() + " is registered for courses: " + courses);
        }

        return ResponseEntity.ok("The student is not registered in the system. Registration cannot be done");



    }



}
