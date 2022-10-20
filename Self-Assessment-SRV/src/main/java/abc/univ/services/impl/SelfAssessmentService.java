package abc.univ.services.impl;

import abc.univ.models.Question;
import abc.univ.models.SelfAssessment;
import abc.univ.repos.IQuestionRepo;
import abc.univ.repos.ISelfAssessmentRepo;
import abc.univ.services.ISelfAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SelfAssessmentService implements ISelfAssessmentService {
    ISelfAssessmentRepo selfAssessmentRepo;
    IQuestionRepo questionRepo;

    @Override
    public SelfAssessment getAssessmentById(Long id) {
        return selfAssessmentRepo.getById(id);
    }

    @Override
    public SelfAssessment generateAssessment(Long studentId, String cat, String subcat) {
        Random rand = new Random();
        List<Question> questions = questionRepo.getQuestionsByCategoryAndSubcategory(cat, subcat);
        int totalQuestions = Math.min(questions.size(), 20);

        List<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < totalQuestions; ++i) {
            // get a random idx into our questions list
            int randomIdx = rand.nextInt(questions.size());
            randomQuestions.add(questions.get(randomIdx));
        }

        // 2. create a new self-assessment consisting of these questions
        SelfAssessment sA = new SelfAssessment();
        sA.setQuestions(randomQuestions);
        selfAssessmentRepo.save(sA);

        return sA;
    }
}
