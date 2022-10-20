package edu.miu.projectmanagement.registrationsrv.model;

import edu.miu.projectmanagement.registrationsrv.enums.Department;
import lombok.*;

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
    public Course(long courseId,String courseTitle, int creditHour,Department department){
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.creditHour = creditHour;
        this.department=department;
    }

    public Course(String courseTitle, int creditHour,Department department){
        this.courseTitle = courseTitle;
        this.creditHour = creditHour;
        this.department=department;
    }
    private String courseTitle;
    private int creditHour;
    private Department department;
    @ManyToMany
    private Set<Student> students;
    @ManyToMany
    private Set<Enrollment> enrollments;


}
