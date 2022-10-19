package abc.univ.repos;

import abc.univ.models.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssessmentResultRepo extends JpaRepository<AssessmentResult, Long> {
    public AssessmentResult getAssessmentResultByStudent_StudentId(Long studentId);
}
