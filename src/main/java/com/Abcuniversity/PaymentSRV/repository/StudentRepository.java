package com.Abcuniversity.PaymentSRV.repository;

import com.Abcuniversity.PaymentSRV.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
