package com.looom.loomservice.Model.Packages;

import com.looom.loomservice.Model.User.Teacher;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Packages")
public class Packages {

    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(nullable = false, name = "name")),
            @AttributeOverride(name = "teacher", column = @Column(nullable = false, name = "teacher"))
    })
    PackagesPrimaryKey id;

    @Column(nullable = false)
    Long price;

    @Column(name = "per", nullable = false)
    Long perHowManyMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(table = "User", name = "id")
    Teacher teacher;

    public Packages() {
    }

    public PackagesPrimaryKey getId() {
        return id;
    }

    public void setId(PackagesPrimaryKey id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPerHowManyMinutes() {
        return perHowManyMinutes;
    }

    public void setPerHowManyMinutes(Long perHowManyMinutes) {
        this.perHowManyMinutes = perHowManyMinutes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packages packages = (Packages) o;
        return id.equals(packages.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Packages{" +
                "id=" + id +
                ", price=" + price +
                ", perHowManyMinutes=" + perHowManyMinutes +
                ", teacher=" + teacher +
                '}';
    }
}
