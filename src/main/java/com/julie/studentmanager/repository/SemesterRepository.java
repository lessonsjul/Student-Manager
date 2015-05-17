package com.julie.studentmanager.repository;

import com.julie.studentmanager.domain.Semester;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SemesterRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addSemester(Semester semester){
        this.sessionFactory.getCurrentSession().save(semester);
    }

    public List<Semester> semesterList(){
        return this.sessionFactory.getCurrentSession().createQuery("from Semester ")
                .list();
    }

    public Semester semesterById(Integer id){
        return (Semester)this.sessionFactory.getCurrentSession().get(Semester.class,id);
    }

    public void editSemester(Semester semester){
        Semester semesterToUpdate = semesterById(semester.getId());

        semesterToUpdate.setName(semester.getName());
        semesterToUpdate.setDuration(semester.getDuration());
        semesterToUpdate.setDisciplineList(semester.getDisciplineList());

        this.sessionFactory.getCurrentSession().update(semesterToUpdate);
    }

    public void removeSemester(Integer id){
        Semester semester = semesterById(id);

        if(null != semester){
            this.sessionFactory.getCurrentSession().delete(semester);
        }
    }



}
