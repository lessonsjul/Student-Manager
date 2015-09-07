package com.julie.studentmanager.repository;

import com.julie.studentmanager.domain.Discipline;
import com.julie.studentmanager.domain.Progress;
import com.julie.studentmanager.domain.Semester;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        return this.sessionFactory.getCurrentSession().createQuery("from Discipline ")
                .list();
    }

/* public List<Discipline> disciplineBySemester(Integer idSem){
        return this.sessionFactory.getCurrentSession().createQuery("from Discipline d join d.semester s where s.id=" + idSem).list();
    }*/


    public Discipline disciplineById(Integer id){
        return (Discipline) this.sessionFactory.getCurrentSession().createCriteria(Discipline.class)
                .add(Restrictions.idEq(id)).uniqueResult();
    }

    public void editDiscipline(Discipline discipline){
        Discipline disciplineToUpdate = disciplineById(discipline.getId());
        disciplineToUpdate.setName(discipline.getName());

        this.sessionFactory.getCurrentSession().update(disciplineToUpdate);
    }

    public void removeDiscipline(Integer id){
        Discipline discipline = disciplineById(id);

        if(null != discipline){
            List<Progress> progress = this.sessionFactory.getCurrentSession()
                    .createQuery("from Progress p where p.discipline.id =" + id).list();
            for(Progress elem: progress) {
                this.sessionFactory.getCurrentSession().delete(elem);
            }
            int semId= discipline.getSemester().getId();
            this.sessionFactory.getCurrentSession().delete(discipline);
            Semester semester = (Semester)this.sessionFactory.getCurrentSession().createCriteria(Semester.class)
                    .add(Restrictions.idEq(semId)).uniqueResult();

            List<Discipline> disciplineList = this.sessionFactory.getCurrentSession()
                    .createQuery("select s.disciplineList from Semester s where s.id =" + semId).list();

            semester.setDisciplineList(disciplineList);
            this.sessionFactory.getCurrentSession().update(semester);
        }
    }


}
