package com.looom.loomservice.Model.Reviews;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
@Table(name = "Reviews")
public class ReviewPrimaryKey implements Serializable {

    private Timestamp dateTime;
    private Long student;

    public ReviewPrimaryKey() {
    }

    public Timestamp getDate() {
        return dateTime;
    }

    public void setDate(Timestamp date) {
        this.dateTime = date;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewPrimaryKey that = (ReviewPrimaryKey) o;
        return dateTime.equals(that.dateTime) &&
                student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, student);
    }

    @Override
    public String toString() {
        return "ReviewPrimaryKey{" +
                "date=" + dateTime +
                ", student=" + student +
                '}';
    }
}
