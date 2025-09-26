package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.DependentEntity;
import com.example.demo.Repository.DependentRepository;

@Service
public class DependentService {

    @Autowired
    DependentRepository dependentRepository;

    public List<DependentEntity> getAllDependents() {
        return dependentRepository.findAll();
    }

    public DependentEntity addDependent(DependentEntity dependent) {
        return dependentRepository.save(dependent);
    }

    public Optional<DependentEntity> getDependentById(Integer id) {
        return dependentRepository.findById(id);
    }

    public DependentEntity updateDependent(Integer id, DependentEntity entity) {
        return dependentRepository.findById(id)
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setBirthdate(entity.getBirthdate());
                    existing.setGender(entity.getGender());
                    existing.setRelationship(entity.getRelationship());
                    existing.setEmployee(entity.getEmployee());
                    return dependentRepository.save(existing);
                }).orElse(null);
    }
}