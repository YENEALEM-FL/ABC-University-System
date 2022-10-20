package edu.miu.projectmanagement.registrationsrv;

import edu.miu.projectmanagement.registrationsrv.enums.Department;
import edu.miu.projectmanagement.registrationsrv.model.Course;
import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.repository.CourseRepository;
import edu.miu.projectmanagement.registrationsrv.repository.StudentRepository;
import edu.miu.projectmanagement.registrationsrv.service.serviceImpl.CourseServiceImpl;
import edu.miu.projectmanagement.registrationsrv.service.serviceImpl.StudentServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseRegistrationServicesTests {
    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentRepository studentRepository;

    @Test
    public void courseRegistrationTest() throws Exception {

        Course course1 = courseService.addCourse(new Course(1L,"Introduction to CS",3, Department.COMPUTER_SCIENCE)).getBody();
        Course courseC = courseRepository.findById(1L).orElse(null);

        Assertions.assertEquals(course1,courseC);



    }

    @Test
    public void addStudentTest() throws Exception {

        Student student1 = studentService.addStudent(new Student(1L,"Smith","Jackson","SmithJackson@gmail.com","432567")).getBody();
        Student studentC = studentRepository.findById(1L).orElse(null);

        Assertions.assertEquals(student1,studentC);

    }


}
