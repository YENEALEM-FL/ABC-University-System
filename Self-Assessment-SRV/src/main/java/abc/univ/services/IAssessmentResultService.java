package abc.univ.services;

import abc.univ.models.Answer;
import abc.univ.models.AssessmentResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssessmentResultService {
    public void save(Long studentId, List<Answer> studentAnswers);
    public AssessmentResult getResultForStudent(Long studentId);
}
