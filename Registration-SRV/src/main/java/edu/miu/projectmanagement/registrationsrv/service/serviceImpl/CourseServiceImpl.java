package edu.miu.projectmanagement.registrationsrv.service.serviceImpl;

import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.repository.CourseRepository;
import edu.miu.projectmanagement.registrationsrv.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Transactional
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ResponseEntity<Course> addCourse(Course course) {

       return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);

    }
}
