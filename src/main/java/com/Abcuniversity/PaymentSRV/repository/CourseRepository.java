package com.Abcuniversity.PaymentSRV.repository;

import com.Abcuniversity.PaymentSRV.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
