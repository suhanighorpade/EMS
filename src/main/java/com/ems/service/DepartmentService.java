package com.ems.service;

import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Transactional
    public List<Department> getDepartmentList()
    {
        return departmentDAO.getDepartments();
    }

    @Transactional
    public void saveDept(Department department) {
        departmentDAO.saveDept(department);
    }

    @Transactional
    public Department getDeptById(int id)
    {
        return departmentDAO.getDepartmentById(id);
    }
}
