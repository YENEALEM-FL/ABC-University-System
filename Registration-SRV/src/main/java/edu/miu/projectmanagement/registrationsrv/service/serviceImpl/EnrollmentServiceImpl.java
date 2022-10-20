package edu.miu.projectmanagement.registrationsrv.service.serviceImpl;

import edu.miu.projectmanagement.registrationsrv.enums.Term;
import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Enrollment;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.repository.EnrollmentRepository;
import edu.miu.projectmanagement.registrationsrv.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Transactional
@Service
public class EnrollmentServiceImpl implements IEnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public ResponseEntity<Set<Student>> registeredStudentsForACourse(long id, Term term, LocalDate registrationDate) {

        int year = registrationDate.getYear();
        return ResponseEntity.ok(enrollmentRepository.findAll().stream()
                .filter(t -> t.getTerm()==term).filter(y->y.getYear()==year)
                .filter( v -> {
                    Set<Course> stud = new HashSet<>();
                    v.getCourses().forEach(c -> {
                        if (c.getCourseId() == id)
                            stud.add(c);
                    });

                    return v.getCourses().contains(stud);
                })
                .map(Enrollment::getStudents)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));

    }
}
