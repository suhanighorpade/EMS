package com.ems.dao;

import com.ems.entity.LoginMaster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.management.LockInfo;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginMasterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(LoginMaster loginMaster) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(loginMaster);

    }

    @Transactional
    public LoginMaster findById(String s) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<LoginMaster> theQuery = currentSession.createQuery("from LoginMaster where userid=:userid", LoginMaster.class);
        theQuery.setParameter("userid",Long.parseLong(s));

        LoginMaster loginMaster;

        try {
            loginMaster = theQuery.getSingleResult();
        } catch (Exception e) {
            loginMaster = null;
        }

        return loginMaster;
    }

    @Transactional
    public List<LoginMaster> getAllCreds() {
        List<LoginMaster> allCreds = new ArrayList<>();

        Session currentSession = sessionFactory.getCurrentSession();

        Query<LoginMaster> theQuery = currentSession.createQuery("from LoginMaster", LoginMaster.class);

        try {
            allCreds = theQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allCreds;
    }
}
