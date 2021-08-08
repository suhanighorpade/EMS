package com.ems.dao;

import com.ems.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Employee> getEmployeeList() {

        List<Employee> employees = new ArrayList<>();

        try{

            Session currentSession = sessionFactory.getCurrentSession();

            System.out.println("executing query to fetch employee list");

            Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);

            employees = query.getResultList();

            System.out.println(employees);

        }
        catch (HibernateException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void saveEmployee(Employee employee) {

        try
        {
            Session currentSession = sessionFactory.getCurrentSession();

            System.out.println("Saving an employee");

            currentSession.saveOrUpdate(employee);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(long id) {

        try {
            Session currentSession = sessionFactory.getCurrentSession();

            Employee employee = currentSession.get(Employee.class, id);

            System.out.println(employee);

            return employee;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteEmployee(long employeeId) {
        try{
            Session currentSession = sessionFactory.getCurrentSession();

            Query query = currentSession.createQuery("delete from Employee where employee_id=:id");

            query.setParameter("id",employeeId);

            int i = query.executeUpdate();

            Query query1 = currentSession.createQuery("delete from LoginMaster where userid=:id");
            query1.setParameter("id",employeeId);
            i = query1.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
