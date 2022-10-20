package edu.miu.projectmanagement.registrationsrv.model;

import edu.miu.projectmanagement.registrationsrv.enums.Term;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EnrollmentId.class)
public class Enrollment {
    @Id
    private int year;
    @Id
    private Term term;
    // on an enrollment many students can get registered
    @ManyToMany
    private Set<Student> students;
    // on an enrollment, there are lots of courses to be registered
    @ManyToMany
    private Set<Course> courses;
}
