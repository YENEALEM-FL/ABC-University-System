package edu.miu.projectmanagement.registrationsrv.model;

import edu.miu.projectmanagement.registrationsrv.enums.Term;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EnrollmentId implements Serializable {
    private Term term;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentId)) return false;
        EnrollmentId that = (EnrollmentId) o;
        return getTerm() == that.getTerm() && Objects.equals(getYear(), that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTerm(), getYear());
    }
}
