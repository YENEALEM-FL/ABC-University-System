package abc.univ.services;

import abc.univ.models.AssessmentSubmission;

public interface IAssessmentSubmissionService {
    public void save(Long assessmentId, AssessmentSubmission submission);
}
