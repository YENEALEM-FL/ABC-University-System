package abc.univ.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class AssessmentSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Student student;

    @ManyToOne
    private SelfAssessment selfAssessment;

    @ElementCollection
    private List<String> studentAnswers;

    private int studentScore;

    public int calculateScore() {
        int score = 0;
        List<Question> assQuestions = selfAssessment.getQuestions();

        for (int i = 0; i < assQuestions.size(); ++i) {
            Question currentQuestion = assQuestions.get(i);
            if (studentAnswers.get(i).equals(currentQuestion.getCorrectAnswer())) {
                score += currentQuestion.getPoints();
            }
        }
        return studentScore = score;
    }
}
