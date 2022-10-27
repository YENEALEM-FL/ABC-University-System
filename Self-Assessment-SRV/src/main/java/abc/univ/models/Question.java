package abc.univ.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String category;
    private String subcategory;
    private int points;
    private String correctAnswer;
    private String incorrectAnswer1;
    private String incorrectAnswer2;
    private String incorrectAnswer3;
}
