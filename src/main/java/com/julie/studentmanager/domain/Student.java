package com.julie.studentmanager.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name="students")
public class Student {

    public Student(){}


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "groupe")
    private String group;

    @Column(name = "entrance_date")
    private String entranceDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = new SimpleDateFormat("dd/M/yyyy").format(entranceDate);
    }
}
