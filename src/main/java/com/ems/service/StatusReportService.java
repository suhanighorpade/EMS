package com.ems.service;

import com.ems.dao.RegulationDAO;
import com.ems.dao.StatusReportDAO;
import com.ems.entity.StatusReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StatusReportService {

    private final StatusReportDAO statusReportDAO;

    @Autowired
    public StatusReportService(StatusReportDAO statusReportDAO) {
        this.statusReportDAO = statusReportDAO;
    }

    @Transactional
    public void saveComment(StatusReport statusReport) {
        statusReportDAO.saveComment(statusReport);
    }

    @Transactional
    public List<StatusReport> getCommentsByEmployee(long emp_id,long reg_id) {
        return statusReportDAO.getCommentsByEmployeeId(emp_id,reg_id);
    }

    @Transactional
    public StatusReport getCommentbyId(long commentId) {
        return statusReportDAO.getCommentById(commentId);
    }

    @Transactional
    public List<StatusReport> getStatusByDepartment(int dept_id)
    {
        return statusReportDAO.getStatusByDepartment(dept_id);
    }

}
