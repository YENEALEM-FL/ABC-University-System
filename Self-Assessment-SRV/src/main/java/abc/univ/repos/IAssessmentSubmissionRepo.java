package abc.univ.repos;

import abc.univ.models.AssessmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssessmentSubmissionRepo extends JpaRepository<AssessmentSubmission, Long> {
}
