package com.Abcuniversity.PaymentSRV.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long enrollmentId;
    private LocalDate enrollmentDate;
    // on an enrollment many students can get registered
    @ManyToMany
    private Set<Student> students;
    // on an enrollment, there are lots of courses to be registered
    @ManyToMany
    private Set<Course> courses;
}
