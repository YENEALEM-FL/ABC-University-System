package com.adminmodule.ABCUniversity;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.adminmodule.ABCUniversity.entity.Student;
import com.adminmodule.ABCUniversity.entity.User;
import com.adminmodule.ABCUniversity.enumm.Role;
import com.adminmodule.ABCUniversity.repository.StudentRepository;
import com.adminmodule.ABCUniversity.service.StudentService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentControllerTest {

	
//	@Autowired
//	private MockMvc mockMvc;   
//	
//	@TestConfiguration
//	static class CustomerServiceImplTestContextConfiguration {
//	    @Bean
//	    public StudentRepository studentrepository() {
//	        return new StudentRepository();
//	    }
//	}
////	
	@InjectMocks
	private StudentService studentservice;
	
	
	
	@Mock
	private StudentRepository studentrepository;
	
	@Test
	public void getAllStudentServiceTest() throws Exception {
		List<Student> studentC=new ArrayList<>();
		
		Student studentC0= studentservice.addOneStudent
				(new Student("joh","sharma", "22sharma@gmail.com", "446l", Role.STUDENT));
//		Student studentC1= studentservice.addOneStudent
//				(new Student("mark","sharma", "22sharma@gmail.com", "446l", Role.STUDENT));
//		
		studentC.add(0, studentC0);
//		studentC.add(1, studentC1);
		Student studentReturned = (Student)studentrepository.findById(1L).orElse(null);
		
//		List<Student> studentsI = studentservice.getAllStudent();
		
		Assertions.assertEquals(studentReturned, studentC);
		
	}
	
//	@Test
//	public void testSaveStudent() throws Exception {
//		Student thestudent=new Student("joh","sharma", "22sharma@gmail.com", "446l", Role.STUDENT);
//		
//		
//	
//		
//}


	
}
