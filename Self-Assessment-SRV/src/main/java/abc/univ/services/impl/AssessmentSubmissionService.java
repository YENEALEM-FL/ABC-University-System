package abc.univ.services.impl;

import abc.univ.models.AssessmentSubmission;
import abc.univ.models.SelfAssessment;
import abc.univ.repos.IAssessmentSubmissionRepo;
import abc.univ.repos.ISelfAssessmentRepo;
import abc.univ.services.IAssessmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AssessmentSubmissionService implements IAssessmentSubmissionService {
    @Autowired
    IAssessmentSubmissionRepo assessmentSubmissionRepo;
    @Autowired
    ISelfAssessmentRepo assessmentRepo;

    @Override
    public void save(Long assessmentId, AssessmentSubmission submission) {
        SelfAssessment assessment = assessmentRepo.getById(assessmentId);
        AssessmentSubmission assSub = new AssessmentSubmission();
        assSub.setSelfAssessment(assessment);
        assSub.setStudent(submission.getStudent());
        assSub.setStudentAnswers(submission.getStudentAnswers());
        assSub.calculateScore();


        assessmentSubmissionRepo.save(submission);
    }
}
