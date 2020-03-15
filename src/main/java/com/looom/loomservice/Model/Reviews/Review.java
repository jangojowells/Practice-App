package com.looom.loomservice.Model.Reviews;

import com.looom.loomservice.Model.User.Student;
import com.looom.loomservice.Model.User.Teacher;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="Reviews")
public class Review {

    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "date", nullable = false, insertable = true, updatable = false)),
            @AttributeOverride(name = "student", column = @Column(name = "student", nullable = false, updatable = false, insertable = true))
    })
    private ReviewPrimaryKey id;

    @Column(name= "rating", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Rating rating;

    @Lob
    @Column(name="review", nullable = false, length = 255)
    private String review;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(table = "User", nullable = false, insertable = true, updatable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(table = "User", nullable = false, insertable = true, updatable = false)
    private Student student;

    public Review() {
    }

    public ReviewPrimaryKey getId() {
        return id;
    }

    public void setId(ReviewPrimaryKey id) {
        this.id = id;
    }

    public Enum<Rating> getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    @PostUpdate
    @PrePersist
    public void setDateBeforePersist(){
        this.id.setDate(new Timestamp(System.currentTimeMillis()));
    }

    public void setStudent(Student student) {
        this.student = student;
        this.id.setStudent(student.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review reviews = (Review) o;
        return id.equals(reviews.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
