package abc.univ.services;

import abc.univ.models.SelfAssessment;

public interface ISelfAssessmentService {
    public SelfAssessment getAssessmentById(Long id);
    public SelfAssessment generateAssessment(Long studentId, String category, String subcategory);
}
