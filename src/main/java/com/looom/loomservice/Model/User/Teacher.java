package com.looom.loomservice.Model.User;

import com.looom.loomservice.Model.Packages.Packages;
import com.looom.loomservice.Model.Reviews.Review;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher extends User {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "teacher")
    Set<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "teacher")
    Set<Packages> packages;

    public Teacher() {
        super();
    }

    @PreUpdate
    @PrePersist
    public void setUserTypeBeforePersist(){
        this.setType(User.TEACHER);
    }

}
