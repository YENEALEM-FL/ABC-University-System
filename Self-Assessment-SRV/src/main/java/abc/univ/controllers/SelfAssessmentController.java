package abc.univ.controllers;

import abc.univ.models.AssessmentSubmission;
import abc.univ.models.Question;
import abc.univ.models.SelfAssessment;
import abc.univ.services.IAssessmentSubmissionService;
import abc.univ.services.ISelfAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assessments")
public class SelfAssessmentController {
    private final ISelfAssessmentService assessmentService;
    private final IAssessmentSubmissionService assessmentSubmissionService;

    @Autowired
    public SelfAssessmentController(ISelfAssessmentService assessmentService, IAssessmentSubmissionService assessmentSubmissionService) {
        this.assessmentService = assessmentService;
        this.assessmentSubmissionService = assessmentSubmissionService;
    }

    @GetMapping
    public List<SelfAssessment> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/{id}")
    public SelfAssessment getAssessmentById(@PathVariable("id") long id) {
        return assessmentService.getAssessmentById(id);
    }

    @GetMapping("/{id}/questions")
    public List<Question> getAssessmentQuestions(@PathVariable("id") Long id) {
        return assessmentService.getAssessmentQuestions(id);
    }

    @GetMapping("/students/{studentId}")
    public SelfAssessment generateAssessment(
            @PathVariable("studentId") Long studentId,
            @RequestParam(name = "c") String cat,
            @RequestParam(name = "s") String subcat) {
        return assessmentService.generateAssessment(studentId, cat, subcat);
    }

    @PostMapping("/{id}")
    public void acceptSubmission(@PathVariable("id") Long id,
                                 @RequestBody AssessmentSubmission result) {
        assessmentSubmissionService.save(id, result);
    }
}
