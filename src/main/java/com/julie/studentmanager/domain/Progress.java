package com.julie.studentmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private int value;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Semester semester;

    public Progress() {
    }

    public Progress(Integer id, int value, Discipline discipline, Student student, Semester semester) {
        this.id = id;
        this.value = value;
        this.discipline = discipline;
        this.student = student;
        this.semester = semester;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}