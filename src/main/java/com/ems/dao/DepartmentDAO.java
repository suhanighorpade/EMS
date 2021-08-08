package com.ems.dao;

import com.ems.entity.Department;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Department> getDepartments()
    {
        try{
            Session currentSession = sessionFactory.getCurrentSession();

            Query<Department> query = currentSession.createQuery("from Department",Department.class);

            List<Department> departmentList =query.getResultList();

            System.out.println(departmentList);

            return departmentList;
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveDept(Department department) {
        try{
            Session currentSession = sessionFactory.getCurrentSession();

            currentSession.save(department);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(int id)
    {
            Session currentSession = sessionFactory.getCurrentSession();

            return currentSession.get(Department.class,id);

    }
}
