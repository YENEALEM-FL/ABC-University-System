package abc.univ.models;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Student {
    private Long studentId;
    private String fullName;

    public Student(Long studentId) {
        this.studentId = studentId;
    }

    public Student() {
    }
}
