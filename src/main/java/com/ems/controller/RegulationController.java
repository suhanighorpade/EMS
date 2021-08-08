package com.ems.controller;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Regulation;
import com.ems.entity.StatusReport;
import com.ems.service.DepartmentService;
import com.ems.service.EmployeeService;
import com.ems.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegulationController {

    private final RegulationService regulationService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @Autowired
    public RegulationController(RegulationService regulationService, DepartmentService departmentService,EmployeeService employeeService) {
        this.regulationService = regulationService;
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/admin/getRegulations")
    public String getRegulationList(Model model)
    {
        List<Regulation> regulationList = regulationService.getRegulationList();

        model.addAttribute("regulations",regulationList);

        return "regulation-list";
    }

    @GetMapping("/admin/addRegForm")
    public String addRegulation(ModelMap model)
    {
        System.out.println("Inside the method : addEmployee");
        model.addAttribute("regulation",new Regulation());
        List<Department> departments = departmentService.getDepartmentList();

        Map<String, Integer> departmentMap = new HashMap<>();

        for (Department department:departments) {
            departmentMap.put(department.getDepartment_name(),department.getDepartment_id());
        }

        model.addAttribute("departmentMap",departmentMap);

        return "regulation-reg";
    }

    @PostMapping("/admin/saveRegulation")
    public String saveRegulation(@Valid @ModelAttribute("regulation") Regulation regulation, BindingResult result)
    {
        if(result.hasErrors())
            return "regulation-reg";

        int department_id = regulation.getDept_id();
        Department department = departmentService.getDeptById(department_id);

        regulation.setDepartment(department);

        regulationService.saveEmployee(regulation);
        return "redirect:/admin/getRegulations";
    }

    //employee methods /employee/**
    @GetMapping("/employee/getRegulations")
    public String getEmployeeRegulationList(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        Employee employee = employeeService.getEmployeeById(Long.parseLong(currentPrincipalName));
        List<Regulation> regulationList = regulationService.getRegulationListByDepartment(employee.getDepartment().getDepartment_id());

        model.addAttribute("regulations",regulationList);

        return "employee-regulation-list";
    }

}
