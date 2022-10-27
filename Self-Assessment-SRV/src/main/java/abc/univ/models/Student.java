package abc.univ.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long studentId = 1L;
    private String fullName = "John Brown";

    public Student(Long studentId) {
        this.studentId = studentId;
    }
}
