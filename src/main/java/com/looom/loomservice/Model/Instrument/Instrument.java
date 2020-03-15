package com.looom.loomservice.Model.Instrument;

import com.looom.loomservice.Model.User.Student;
import com.looom.loomservice.Model.User.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Instruments")
public class Instrument {

    public static enum SkillLevel{
        LOW,
        MEDIUM,
        EXPERT
    }

    @Id
    private InstrumentPrimaryKey id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private SkillLevel level;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Instruments",
            joinColumns = {@JoinColumn(name = "instrument")},
            inverseJoinColumns = {@JoinColumn(name = "user")}
    )
    private Set<Teacher> teachers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Instruments",
            joinColumns = {@JoinColumn(name = "instrument")},
            inverseJoinColumns = {@JoinColumn(name = "user")}
    )
    private Set<Student> students = new HashSet<>();

    public Instrument() {
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    public InstrumentPrimaryKey getId() {
        return id;
    }

    public void setId(InstrumentPrimaryKey id) {
        this.id = id;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }
}
