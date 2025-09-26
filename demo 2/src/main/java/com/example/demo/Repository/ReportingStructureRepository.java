package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.ReportingStructureEntity;
import com.example.demo.Entities.ReportingStructureId;

@Repository
public interface ReportingStructureRepository extends JpaRepository<ReportingStructureEntity, ReportingStructureId> {
}