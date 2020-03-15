package com.looom.loomservice.Model.User;
import com.looom.loomservice.Model.Booking.Booking;
import com.looom.loomservice.Model.Reviews.Review;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends User {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student")
    Set<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "student" )
    Set<Booking> bookings = new HashSet<Booking>();

    public Student() {
        super();
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @PreUpdate
    @PrePersist
    public void setUserTypeBeforePersist(){
        this.setType(User.STUDENT);
    }
}
