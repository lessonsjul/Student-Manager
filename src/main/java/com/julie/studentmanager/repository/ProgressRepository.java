package com.julie.studentmanager.repository;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProgressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Object> getProgressListByStudIdAndSemId(Integer stuId, Integer semId) {
//        String sql = "select p.value, p.student, p.discipline from Progress p join p.student s join p.discipline d " +
//                "where s.id=?";
        String sql = "select p.value, p.student, p.discipline from Progress p join p.student s join p.discipline d " +
                "where s.id=? and d.semester.id=?";
        Query query = this.sessionFactory.getCurrentSession().createQuery(sql);
        query.setInteger(0, stuId);
        query.setInteger(1, semId);

        return (List<Object>) query.list();
    }


    public double getAvarageValueOfProgress(Integer stuId, Integer semId){
        Object s = this.sessionFactory.getCurrentSession()
                .createQuery("select AVG(p.value) from Progress p" +
                        " where p.discipline.semester.id=" + semId + " and p.student.id=" + stuId).uniqueResult();

        return Double.parseDouble(String.valueOf(s));
        }


}
