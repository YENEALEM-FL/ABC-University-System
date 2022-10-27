package abc.univ.services;

import abc.univ.models.Question;
import abc.univ.models.SelfAssessment;

import java.util.List;
import java.util.Set;

public interface ISelfAssessmentService {
    List<SelfAssessment> getAllAssessments();
    SelfAssessment getAssessmentById(Long id);
    List<Question> getAssessmentQuestions(Long assessmentId);
    SelfAssessment generateAssessment(Long studentId, String category, String subcategory);
}
