package com.looom.loomservice.Model.Booking;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class BookingPrimaryKey implements Serializable {

    private Long student;
    private Timestamp start;

    public BookingPrimaryKey() {
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "BookingPrimaryKey{" +
                "student=" + student +
                ", start=" + start +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingPrimaryKey that = (BookingPrimaryKey) o;
        return student.equals(that.student) &&
                start.equals(that.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, start);
    }
}
