package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.ReportingStructureEntity;
import com.example.demo.Entities.ReportingStructureId;
import com.example.demo.Service.ReportingStructureService;

@RestController
@RequestMapping("/api/reportingstructure")
public class ReportingStructureController {

    @Autowired
    ReportingStructureService reportingStructureService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReportingStructureEntity>> getAllReportingStructures() {
        return ResponseEntity.ok(reportingStructureService.getAllReportingStructures());
    }

    @PostMapping("/add")
    public ResponseEntity<ReportingStructureEntity> addReportingStructure(
            @RequestBody ReportingStructureEntity reportingStructure) {
        return ResponseEntity.ok(reportingStructureService.addReportingStructure(reportingStructure));
    }

    @GetMapping("/getById")
    public ResponseEntity<ReportingStructureEntity> getReportingStructureById(@RequestParam Integer managerSsn,
            @RequestParam Integer employeeSsn) {
        ReportingStructureId id = new ReportingStructureId(managerSsn, employeeSsn);
        return reportingStructureService.getReportingStructureById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<ReportingStructureEntity> updateReportingStructure(@RequestParam Integer managerSsn,
            @RequestParam Integer employeeSsn, @RequestBody ReportingStructureEntity entity) {
        ReportingStructureId id = new ReportingStructureId(managerSsn, employeeSsn);
        ReportingStructureEntity updated = reportingStructureService.updateReportingStructure(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}