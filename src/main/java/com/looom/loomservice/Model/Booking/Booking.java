package com.looom.loomservice.Model.Booking;

import com.looom.loomservice.Model.Packages.Packages;
import com.looom.loomservice.Model.User.Student;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    private BookingPrimaryKey id;

    @Column(nullable = false)
    private Timestamp end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn( name = "package", nullable = false, insertable = false, updatable = false),
            @JoinColumn( name = "student", nullable = false, insertable = false, updatable = false)
    })
    private Packages packages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student", nullable = false, insertable = false, updatable = false)
    private Student student;

    public Booking() {
    }

    public BookingPrimaryKey getId() {
        return id;
    }

    public void setId(BookingPrimaryKey id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return this.id.getStart();
    }

    public void setStart(Timestamp start) {
        this.id.setStart(start);
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public void setEnd(Long end) {
        this.end = new Timestamp(end);
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", end=" + end +
                ", packages=" + packages +
                ", student=" + student +
                '}';
    }
}
