package abc.univ.controllers;

import abc.univ.models.SelfAssessment;
import abc.univ.services.ISelfAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assessments")
public class SelfAssessmentController {

    private final ISelfAssessmentService assessmentService;

    @GetMapping("/{assessmentId}")
    public SelfAssessment getAssessmentById(@PathVariable("assessmentId") long id) {
        return assessmentService.getAssessmentById(id);
    }

    @GetMapping("/students/{studentId}")
    public SelfAssessment generateAssessment(
            @PathVariable("studentId") Long studentId,
            @RequestParam(name = "c") String cat,
            @RequestParam(name = "s") String subcat) {
        return assessmentService.generateAssessment(studentId, cat, subcat);
    }


}
