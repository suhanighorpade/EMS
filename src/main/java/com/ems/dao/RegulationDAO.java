package com.ems.dao;

import com.ems.entity.Employee;
import com.ems.entity.Regulation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegulationDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public RegulationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Regulation> getRegulationList() {

        List<Regulation> regulations = new ArrayList<>();

        try{

            Session currentSession = sessionFactory.getCurrentSession();

            System.out.println("executing query to fetch regulations list");

            Query<Regulation> query = currentSession.createQuery("from Regulation",Regulation.class);

            regulations = query.getResultList();

            System.out.println(regulations);

        }
        catch (HibernateException e) {
            e.printStackTrace();
        }

        return regulations;

    }

    public void saveRegulation(Regulation regulation) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(regulation);

    }

    public List<Regulation> getRegulationListByDepartment(int department_id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Regulation> query = currentSession.createQuery("from Regulation where department_id=:id",Regulation.class);
        query.setParameter("id",department_id);

        List<Regulation> regulationList = query.getResultList();

        System.out.println(regulationList);

        return regulationList;
    }

    public Regulation getRegulationById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Regulation regulation = currentSession.get(Regulation.class,id);

        System.out.println(regulation);

        return regulation;
    }
}
