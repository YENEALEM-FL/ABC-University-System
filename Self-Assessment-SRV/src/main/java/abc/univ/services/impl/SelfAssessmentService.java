package abc.univ.services.impl;

import abc.univ.models.Question;
import abc.univ.models.SelfAssessment;
import abc.univ.repos.IQuestionRepo;
import abc.univ.repos.ISelfAssessmentRepo;
import abc.univ.services.ISelfAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class SelfAssessmentService implements ISelfAssessmentService {
    ISelfAssessmentRepo selfAssessmentRepo;
    IQuestionRepo questionRepo;

    @Autowired
    SelfAssessmentService(ISelfAssessmentRepo selfAssessmentRepo, IQuestionRepo questionRepo) {
        this.selfAssessmentRepo = selfAssessmentRepo;
        this.questionRepo = questionRepo;
    }

    @Override
    public List<SelfAssessment> getAllAssessments() {
        return selfAssessmentRepo.findAll();
    }

    @Override
    public SelfAssessment getAssessmentById(Long id) {
        return selfAssessmentRepo.getById(id);
    }

    @Override
    public List<Question> getAssessmentQuestions(Long assessmentId) {
        SelfAssessment assessment = selfAssessmentRepo.getById(assessmentId);
        return new ArrayList<>(assessment.getQuestions());
    }

    @Override
    public SelfAssessment generateAssessment(Long studentId, String cat, String subcat) {
        List<Question> questions = questionRepo.getQuestionsByCategoryAndSubcategory(cat, subcat);

        int totalQuestions = Math.min(questions.size(), 20);
        int count = 0;

        List<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < totalQuestions && count <= 20; ++i) {
            randomQuestions.add(questions.get(i));
            ++count;
        }

        // 2. create a new self-assessment consisting of these questions
        SelfAssessment sA = new SelfAssessment();
        sA.setTitle("Self Assessment: " + subcat);
        LocalDate curDate = LocalDate.now();
        sA.setDateGenerated(curDate);
        sA.setDueDate(curDate.plusDays(1));
        sA.setQuestions(randomQuestions);
        selfAssessmentRepo.save(sA);

        return sA;
    }
}
