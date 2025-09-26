package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.DeptLocEntity;

@Repository
public interface DeptLocRepository extends JpaRepository<DeptLocEntity, Integer> {
}