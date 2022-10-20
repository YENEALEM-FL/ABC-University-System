package edu.miu.projectmanagement.registrationsrv.repository;

import edu.miu.projectmanagement.registrationsrv.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
