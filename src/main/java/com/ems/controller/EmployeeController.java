package com.ems.controller;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.LoginMaster;
import com.ems.service.DepartmentService;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController
{
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }


    @GetMapping("/admin/getEmployees")
    public String getEmployeeList(Model model)
    {
        System.out.println("Inside the method: getEmployeeList EmployeeController!");
        List<Employee> employees = employeeService.getEmployeeList();
        model.addAttribute("employees",employees);

        return "employee-list";
    }

    @GetMapping("/admin/addEmpForm")
    public String addEmployee(ModelMap model)
    {
        System.out.println("Inside the method : addEmployee");
        model.addAttribute("employee",new Employee());
        List<Department> departments = departmentService.getDepartmentList();

        Map<String, Integer> departmentMap = new HashMap<>();

        for (Department department:departments) {
            departmentMap.put(department.getDepartment_name(),department.getDepartment_id());
        }

        model.addAttribute("departmentMap",departmentMap);

        return "employee-reg";
    }

    @PostMapping("/admin/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {

        System.out.println(result.hasErrors());

        if (result.hasErrors())
            return "employee-reg";

        int department_id = employee.getDepartment_id();
        Department department = departmentService.getDeptById(department_id);

        employee.setDept(department);

        employeeService.saveEmployee(employee);
        System.out.println(employee);
        LoginMaster loginMaster = new LoginMaster(employee.getEmployee_id());
        System.out.println(loginMaster);
        employee.setLoginMaster(loginMaster);

        employeeService.saveEmployee(employee);

        return "redirect:/admin/getEmployees";
    }

    @GetMapping("/admin/editEmployee")
    public String editEmployee(@RequestParam("employeeId") long employeeId, Model model)
    {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee",employee);

        List<Department> departments = departmentService.getDepartmentList();

        Map<String, Integer> departmentMap = new HashMap<>();

        for (Department department:departments) {
            departmentMap.put(department.getDepartment_name(),department.getDepartment_id());
        }

        model.addAttribute("departmentMap",departmentMap);

        return "employee-reg";
    }

    @GetMapping("/admin/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") long employeeId)
    {
        employeeService.deleteEmployee(employeeId);

        return "redirect:/admin/getEmployees";
    }


}
