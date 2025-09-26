package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.DependentEntity;

@Repository
public interface DependentRepository extends JpaRepository<DependentEntity, Integer> {
}