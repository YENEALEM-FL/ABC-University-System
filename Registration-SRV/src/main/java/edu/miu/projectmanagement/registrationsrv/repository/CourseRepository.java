package edu.miu.projectmanagement.registrationsrv.repository;

import edu.miu.projectmanagement.registrationsrv.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
