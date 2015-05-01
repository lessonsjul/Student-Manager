package com.julie.studentmanager.repository;


import com.julie.studentmanager.domain.Progress;
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

    public List<Progress> progressListByStudId(Integer id) {
        return this.sessionFactory.getCurrentSession().createQuery("FROM Progress where student.id=" + id).list();
    }

    public List<Progress> progressList(Integer id, Integer semId) {
       return this.sessionFactory.getCurrentSession().createQuery("FROM Progress where student.id=" + id + " and semester.id=" + semId).list();
    }

}
