package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.DeptLocEntity;
import com.example.demo.Repository.DeptLocRepository;

@Service
public class DeptLocService {

    @Autowired
    DeptLocRepository deptLocRepository;

    public List<DeptLocEntity> getAllDeptLocs() {
        return deptLocRepository.findAll();
    }

    public DeptLocEntity addDeptLoc(DeptLocEntity deptLoc) {
        return deptLocRepository.save(deptLoc);
    }

    public Optional<DeptLocEntity> getDeptLocById(Integer id) {
        return deptLocRepository.findById(id);
    }

    public DeptLocEntity updateDeptLoc(Integer id, DeptLocEntity entity) {
        return deptLocRepository.findById(id)
                .map(existing -> {
                    existing.setLocation(entity.getLocation());
                    // Ensure entity.getDepartment() returns a DepartmentEntity, not a String
                    existing.setDepartment(entity.getDepartment());
                    return deptLocRepository.save(existing);
                }).orElse(null);
    }
}