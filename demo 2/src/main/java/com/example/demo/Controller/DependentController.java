package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.DependentEntity;
import com.example.demo.Service.DependentService;

@RestController
@RequestMapping("/api/dependents")
public class DependentController {

    @Autowired
    DependentService dependentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DependentEntity>> getAllDependents() {
        return ResponseEntity.ok(dependentService.getAllDependents());
    }

    @PostMapping("/add")
    public ResponseEntity<DependentEntity> addDependent(@RequestBody DependentEntity dependent) {
        return ResponseEntity.ok(dependentService.addDependent(dependent));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DependentEntity> getDependentById(@PathVariable Integer id) {
        return dependentService.getDependentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DependentEntity> updateDependent(@PathVariable Integer id,
            @RequestBody DependentEntity entity) {
        DependentEntity updated = dependentService.updateDependent(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}