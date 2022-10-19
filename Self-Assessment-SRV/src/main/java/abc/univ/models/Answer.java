package abc.univ.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Student student;

    @ManyToOne
    @JoinColumn(name = "self_assessment_id")
    private SelfAssessment selfAssessment;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String studentAnswer;
}
