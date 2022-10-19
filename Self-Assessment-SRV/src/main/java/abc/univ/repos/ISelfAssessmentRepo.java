package abc.univ.repos;

import abc.univ.models.SelfAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISelfAssessmentRepo extends JpaRepository<SelfAssessment, Long> {

}
