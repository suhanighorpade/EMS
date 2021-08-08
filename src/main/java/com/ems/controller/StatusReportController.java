package com.ems.controller;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Regulation;
import com.ems.entity.StatusReport;
import com.ems.service.DepartmentService;
import com.ems.service.EmployeeService;
import com.ems.service.RegulationService;
import com.ems.service.StatusReportService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatusReportController {

    private final StatusReportService statusReportService;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final RegulationService regulationService ;

    @Autowired
    public StatusReportController(StatusReportService statusReportService, EmployeeService employeeService,
                                  DepartmentService departmentService, RegulationService regulationService) {
        this.statusReportService = statusReportService;
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.regulationService = regulationService;
    }

    @GetMapping("/employee/addComment")
    private String addComment(@RequestParam("regulationId") String regulationId, ModelMap model)
    {

        Regulation regulation = regulationService.getRegulationById(Integer.parseInt(regulationId));

        StatusReport statusReport = new StatusReport();

        model.addAttribute("comment",statusReport);
        model.addAttribute("regulation",regulation);

        return "add-comment";
    }

    @PostMapping("/employee/saveComment")
    private String saveComment(@ModelAttribute StatusReport statusReport, BindingResult result)
    {
        if(result.hasErrors())
            return "add-comment";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Employee employee = employeeService.getEmployeeById(Long.parseLong(currentPrincipalName));
        Department department = departmentService.getDeptById(employee.getDepartment().getDepartment_id());
        Regulation regulation = regulationService.getRegulationById(statusReport.getRegulation_id());
        statusReport.setEmployee(employee);
        statusReport.setDepartment(department);
        statusReport.setRegulation(regulation);

        statusReportService.saveComment(statusReport);
        System.out.println(statusReport);

        return "redirect:/employee/getRegulations";

    }

    @GetMapping("/employee/viewComments")
    public String viewComments(@RequestParam("regulationId") String regulationId,Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        long employee_id = Long.parseLong(currentPrincipalName);
        List<StatusReport> myComments = statusReportService.getCommentsByEmployee(employee_id,Long.parseLong(regulationId));

        model.addAttribute("myComments",myComments);

        return "view-comments";
    }

    @GetMapping("/employee/editComment")
    public String editComment(@RequestParam("commentId") long commentId, Model model)
    {
        StatusReport comment = statusReportService.getCommentbyId(commentId);

        model.addAttribute("comment",comment);

        return "add-comment";
    }

    @GetMapping("/employee/trackStatus")
    public String trackStatusForEmployee(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Employee employee = employeeService.getEmployeeById(Long.parseLong(currentPrincipalName));

        List<StatusReport> allComments = statusReportService.getStatusByDepartment(employee.getDepartment().getDepartment_id());

        model.addAttribute("status",allComments);
        model.addAttribute("department",employee.getDepartment());

        return "status_page";
    }

    @GetMapping("/admin/trackStatus")
    public String trackStatusforAdmin(@RequestParam("dept_id") int dept_id,Model model)
    {
        List<StatusReport> allComments = statusReportService.getStatusByDepartment(dept_id);
        Department department = departmentService.getDeptById(dept_id);

        model.addAttribute("status",allComments);
        model.addAttribute("department",department);

        return "status_page";
    }



}
