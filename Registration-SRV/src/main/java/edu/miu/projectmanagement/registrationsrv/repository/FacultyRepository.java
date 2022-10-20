package edu.miu.projectmanagement.registrationsrv.repository;

import edu.miu.projectmanagement.registrationsrv.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
