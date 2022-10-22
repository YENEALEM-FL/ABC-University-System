package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;
    private String courseTitle;
    private int creditHour;
    @ManyToMany
    private Set<Student> students;
    @ManyToMany
    private Set<Enrollment> enrollments;
}

