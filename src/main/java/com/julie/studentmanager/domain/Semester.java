package com.julie.studentmanager.domain;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semester")
public class Semester{
    public Semester() {
    }

    public Semester(Integer duration, String name, List<Discipline> disciplineList) {
        this.duration = duration;
        this.name = name;
        this.disciplineList = disciplineList;
    }

    public Semester(Integer id, Integer duration, String name, List<Discipline> disciplineList) {
        this.id = id;
        this.duration = duration;
        this.name = name;
        this.disciplineList = disciplineList;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    private Integer id;


    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "duration")
    private Integer duration;
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "disciplines_has_semester",
            joinColumns = @JoinColumn(name = "semester_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplines_id"))
    @IndexColumn(name = "idx")
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }
    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }
    private List<Discipline> disciplineList;
}
