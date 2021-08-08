package com.ems.service;

import com.ems.dao.RegulationDAO;
import com.ems.entity.Regulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegulationService {

    private final RegulationDAO regulationDAO;

    @Autowired
    public RegulationService(RegulationDAO regulationDAO) {
        this.regulationDAO = regulationDAO;
    }

    @Transactional
    public List<Regulation> getRegulationList() {
        return regulationDAO.getRegulationList();
    }

    @Transactional
    public void saveEmployee(Regulation regulation) {
        regulationDAO.saveRegulation(regulation);
    }

    @Transactional
    public List<Regulation> getRegulationListByDepartment(int department_id) {
        return regulationDAO.getRegulationListByDepartment(department_id);
    }

    @Transactional
    public Regulation getRegulationById(int id) {
        return  regulationDAO.getRegulationById(id);
    }
}
