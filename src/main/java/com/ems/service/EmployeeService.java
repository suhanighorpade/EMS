package com.ems.service;



import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public List<Employee> getEmployeeList() {
        System.out.println("Inside the method getEmployeeList in EmployeeService");
        return employeeDAO.getEmployeeList();
    }

    @Transactional
    public void saveEmployee(Employee employee) {

        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    public Employee getEmployeeById(long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Transactional
    public void deleteEmployee(long employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
}
