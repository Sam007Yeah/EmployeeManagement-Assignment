package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.WorksOnEntity;
import com.example.demo.Entities.WorksOnId;
import com.example.demo.Repository.WorksOnRepository;

@Service
public class WorksOnService {

    @Autowired
    WorksOnRepository worksOnRepository;

    public List<WorksOnEntity> getAllWorksOn() {
        return worksOnRepository.findAll();
    }

    public WorksOnEntity addWorksOn(WorksOnEntity worksOn) {
        return worksOnRepository.save(worksOn);
    }

    public Optional<WorksOnEntity> getWorksOnById(WorksOnId id) {
        return worksOnRepository.findById(id);
    }

    public WorksOnEntity updateWorksOn(WorksOnId id, WorksOnEntity entity) {
        return worksOnRepository.findById(id)
                .map(existing -> {
                    existing.setHoursWorked(entity.getHoursWorked());
                    existing.setEmployee(entity.getEmployee());
                    existing.setProject(entity.getProject());
                    return worksOnRepository.save(existing);
                }).orElse(null);
    }
}