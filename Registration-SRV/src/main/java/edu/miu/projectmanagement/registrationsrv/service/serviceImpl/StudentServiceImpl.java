package edu.miu.projectmanagement.registrationsrv.service.serviceImpl;

import edu.miu.projectmanagement.registrationsrv.model.Student;
import edu.miu.projectmanagement.registrationsrv.repository.StudentRepository;
import edu.miu.projectmanagement.registrationsrv.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Student> addStudent(Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }


}
