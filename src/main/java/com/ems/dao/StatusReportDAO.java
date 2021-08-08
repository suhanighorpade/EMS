package com.ems.dao;

import com.ems.entity.Employee;
import com.ems.entity.Regulation;
import com.ems.entity.StatusReport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatusReportDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StatusReportDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void saveComment(StatusReport statusReport) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(statusReport);

    }

    public List<StatusReport> getCommentsByEmployeeId(long emp_id, long reg_id) {

        List<StatusReport> myComments = new ArrayList<>();

        try{

            Session currentSession = sessionFactory.getCurrentSession();

            System.out.println("executing query to fetch comments list");

            Query<StatusReport> query = currentSession.createQuery("from StatusReport where emp_id=:emp_id and complianceid=:id",StatusReport.class);
            query.setParameter("emp_id",emp_id);
            query.setParameter("id",reg_id);

            myComments = query.getResultList();

            System.out.println(myComments);

        }
        catch (HibernateException e) {
            e.printStackTrace();
        }

        return myComments;
    }

    public StatusReport getCommentById(long commentId) {

        try {
            Session currentSession = sessionFactory.getCurrentSession();

            StatusReport statusReport = currentSession.get(StatusReport.class,commentId);

            System.out.println(statusReport);

            return statusReport;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<StatusReport> getStatusByDepartment(int dept_id) {

        List<StatusReport> statusReport = new ArrayList<>();

        try{

            Session currentSession = sessionFactory.getCurrentSession();

            System.out.println("executing query to fetch comments list by department");

            Query<StatusReport> query = currentSession.createQuery("from StatusReport where department_id=:id",StatusReport.class);

            query.setParameter("id",dept_id);

            statusReport = query.getResultList();

            System.out.println(statusReport);

        }
        catch (HibernateException e) {
            e.printStackTrace();
        }

        return statusReport;
    }

}
