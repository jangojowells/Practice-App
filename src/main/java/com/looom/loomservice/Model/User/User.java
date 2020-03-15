package com.looom.loomservice.Model.User;

import com.looom.loomservice.Model.Booking.Booking;
import com.looom.loomservice.Model.Reviews.Review;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@MappedSuperclass
@Table(name = "User")
class User {

    public static final String TEACHER = "TEACHER";

    public static final String STUDENT = "STUDENT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false, insertable = true)
    Long id;

    @Column(nullable = false, updatable = true, insertable = true)
    String type;

    @Column(nullable = false, updatable = true, insertable = true)
    String firstName;

    @Column(nullable = false, updatable = true, insertable = true)
    String lastName;

    User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
