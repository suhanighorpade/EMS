package com.ems.controller;

import com.ems.entity.Department;
import com.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/admin/addDeptForm")
    public String addDepartmentForm(Model model)
    {
        model.addAttribute("department",new Department());
        return "department-reg";
    }

    @GetMapping("/admin/getDepartments")
    public String getDepartmentList(Model model)
    {
        List<Department> departments = departmentService.getDepartmentList();
        model.addAttribute("departments",departments);

        return "department-list";
    }

    @PostMapping("/admin/saveDept")
    public String saveDept(@ModelAttribute("department") Department department)
    {
        departmentService.saveDept(department);
        return "redirect:/admin/getDepartments";
    }

}
