package com.Abcuniversity.PaymentSRV.repository;


import com.Abcuniversity.PaymentSRV.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
