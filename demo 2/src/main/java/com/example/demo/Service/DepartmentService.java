package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.DepartmentEntity;
import com.example.demo.Repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity addDepartment(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public Optional<DepartmentEntity> getDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    public DepartmentEntity updateDepartment(Integer id, DepartmentEntity entity) {
        return departmentRepository.findById(id)
                .map(existing -> {
                    existing.setDeptName(entity.getDeptName());
                    existing.setManager(entity.getManager());
                    existing.setManagerStartDate(entity.getManagerStartDate());
                    return departmentRepository.save(existing);
                }).orElse(null);
    }
}