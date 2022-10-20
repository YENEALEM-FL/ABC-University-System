package edu.miu.projectmanagement.registrationsrv.repository;

import edu.miu.projectmanagement.registrationsrv.model.Enrollment;
import edu.miu.projectmanagement.registrationsrv.model.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

}
