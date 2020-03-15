package com.looom.loomservice.Model.User;

import com.looom.loomservice.Model.Instrument.Instrument;
import com.looom.loomservice.Model.Reviews.Review;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends User {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student")
    Set<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "students")
    Set<Instrument> instruments;

    public Student() {
        super();
    }

    @PreUpdate
    @PrePersist
    public void setUserTypeBeforePersist(){
        this.setType(User.STUDENT);
    }
}
