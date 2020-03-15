package com.looom.loomservice.Model.Packages;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PackagesPrimaryKey implements Serializable {
    String name;
    Long teacher;

    public PackagesPrimaryKey() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagesPrimaryKey that = (PackagesPrimaryKey) o;
        return name.equals(that.name) &&
                teacher.equals(that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher);
    }

    @Override
    public String toString() {
        return "PackagesPrimaryKey{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
