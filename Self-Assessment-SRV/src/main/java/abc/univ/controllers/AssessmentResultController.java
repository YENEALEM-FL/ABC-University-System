package abc.univ.controllers;

import abc.univ.models.Answer;
import abc.univ.models.AssessmentResult;
import abc.univ.services.IAssessmentResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assessments/results")
public class AssessmentResultController {
    private IAssessmentResultService assessmentResultService;

    @PostMapping("/{studentId}")
    public void submitAssessment(@PathVariable("studentId") Long studentId, @RequestBody List<Answer> studentAnswers) {

        //assessmentResultService.calculateScore();
        // Now save the student's assessment result
        assessmentResultService.save(studentId, studentAnswers);
    }

    @GetMapping("/{studentId}")
    public AssessmentResult getResults(@PathVariable("studentId") Long studentId) {
        return assessmentResultService.getResultForStudent(studentId);
    }
}
