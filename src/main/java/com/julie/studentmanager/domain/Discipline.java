package com.julie.studentmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "disciplines")
public class Discipline {
    public Discipline() {
    }

    public Discipline(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;



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
}