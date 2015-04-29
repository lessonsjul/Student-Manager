package com.julie.studentmanager.repository;

import com.julie.studentmanager.domain.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(Student student){
        this.sessionFactory.getCurrentSession().save(student);
    }

    public List<Student> studentList(){
        return this.sessionFactory.getCurrentSession().createQuery("from Student")
                .list();
    }

    public Student studentById(Integer id){
        Student student = (Student) this.sessionFactory.getCurrentSession().load(Student.class, id);
        return student;
    }

    public void modifyStudent(Student student, Integer id){
        Student studentToUpdate = studentById(id);
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setSecondName(student.getSecondName());
        studentToUpdate.setGroup(student.getGroup());
        studentToUpdate.setEntranceDate(student.getEntranceDate());

        this.sessionFactory.getCurrentSession().update(studentToUpdate);
    }

    public void removeStudent(Integer id){
        Student student = (Student) this.sessionFactory.getCurrentSession().load(Student.class,id);

        if(null != student){
            this.sessionFactory.getCurrentSession().delete(student);
        }
    }
}
