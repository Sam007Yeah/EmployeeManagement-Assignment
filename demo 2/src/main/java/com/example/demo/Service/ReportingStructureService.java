package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.ReportingStructureEntity;
import com.example.demo.Entities.ReportingStructureId;
import com.example.demo.Repository.ReportingStructureRepository;

@Service
public class ReportingStructureService {

    @Autowired
    ReportingStructureRepository reportingStructureRepository;

    public List<ReportingStructureEntity> getAllReportingStructures() {
        return reportingStructureRepository.findAll();
    }

    public ReportingStructureEntity addReportingStructure(ReportingStructureEntity reportingStructure) {
        return reportingStructureRepository.save(reportingStructure);
    }

    public Optional<ReportingStructureEntity> getReportingStructureById(ReportingStructureId id) {
        return reportingStructureRepository.findById(id);
    }

    public ReportingStructureEntity updateReportingStructure(ReportingStructureId id, ReportingStructureEntity entity) {
        return reportingStructureRepository.findById(id)
                .map(existing -> {
                    existing.setManager(entity.getManager());
                    existing.setEmployee(entity.getEmployee());
                    return reportingStructureRepository.save(existing);
                })
                .orElse(null);
    }
}