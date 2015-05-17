package com.julie.studentmanager.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "semesters")
public class Semester {
    public Semester() {
    }

    public Semester(String name, Integer duration, Set<Discipline> disciplineList) {
        this.name = name;
        this.duration = duration;
        this.disciplineList = disciplineList;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany
    private Set<Discipline> disciplineList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(Set<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
