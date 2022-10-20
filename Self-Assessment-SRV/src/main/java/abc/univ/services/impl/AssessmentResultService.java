package abc.univ.services.impl;

import abc.univ.models.Answer;
import abc.univ.models.AssessmentResult;
import abc.univ.models.Student;
import abc.univ.repos.IAssessmentResultRepo;
import abc.univ.services.IAssessmentResultService;

import java.util.List;

public class AssessmentResultService implements IAssessmentResultService {
    private IAssessmentResultRepo assessmentResultRepo;

    @Override
    public void save(Long studentId, List<Answer> studentAnswers) {
        AssessmentResult assessmentResult = new AssessmentResult();
        assessmentResult.setStudent(new Student(studentId));
        assessmentResult.setStudentAnswers(studentAnswers);
        assessmentResult.calculateScore();
        assessmentResultRepo.save(assessmentResult);
    }

    @Override
    public AssessmentResult getResultForStudent(Long studentId) {
        return assessmentResultRepo.getAssessmentResultByStudent_StudentId(studentId);
    }
}
