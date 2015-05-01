package com.julie.studentmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "semester_discipline")
public class SemesterDiscipline {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "semester_id",referencedColumnName = "id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "discipline_id",referencedColumnName = "id")
    private Discipline discipline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
