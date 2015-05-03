package com.julie.studentmanager.repository;

import com.julie.studentmanager.domain.Discipline;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DisciplineRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDiscipline(Discipline discipline){
        this.sessionFactory.getCurrentSession().save(discipline);
    }

    public List<Discipline> disciplineList(){
        return this.sessionFactory.getCurrentSession().createQuery("from Discipline")
                .list();
    }

    public Discipline disciplineById(Integer id){
        return (Discipline) this.sessionFactory.getCurrentSession().get(Discipline.class,id);
    }

    public void modifyDiscipline(Discipline discipline, Integer id){
        Discipline disciplineToUpdate = disciplineById(id);
        disciplineToUpdate.setName(discipline.getName());
        this.sessionFactory.getCurrentSession().update(disciplineToUpdate);
    }

    public void removeDiscipline(Integer id){
        Discipline discipline = disciplineById(id);

        if(null != discipline){
            this.sessionFactory.getCurrentSession().delete(discipline);
        }
    }


}
