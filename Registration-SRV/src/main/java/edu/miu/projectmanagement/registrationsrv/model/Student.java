package edu.miu.projectmanagement.registrationsrv.model;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("User_Student")
public class Student extends User{
    public Student(long userId, String firstName, String lastName, String email, String password) {
        super(userId, firstName, lastName, email, password);
    }

    // a student can take many courses at a time
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;

    // a student can have many enrollments
    @ManyToMany
    private Set<Enrollment> enrollments;
}
