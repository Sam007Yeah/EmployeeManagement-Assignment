package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.DepartmentEntity;
import com.example.demo.Service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DepartmentEntity>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentEntity> addDepartment(@RequestBody DepartmentEntity department) {
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable Integer id,
            @RequestBody DepartmentEntity entity) {
        DepartmentEntity updated = departmentService.updateDepartment(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}