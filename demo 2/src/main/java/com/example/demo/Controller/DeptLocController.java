package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.DeptLocEntity;
import com.example.demo.Service.DeptLocService;

@RestController
@RequestMapping("/api/deptlocs")
public class DeptLocController {

    @Autowired
    DeptLocService deptLocService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DeptLocEntity>> getAllDeptLocs() {
        return ResponseEntity.ok(deptLocService.getAllDeptLocs());
    }

    @PostMapping("/add")
    public ResponseEntity<DeptLocEntity> addDeptLoc(@RequestBody DeptLocEntity deptLoc) {
        return ResponseEntity.ok(deptLocService.addDeptLoc(deptLoc));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DeptLocEntity> getDeptLocById(@PathVariable Integer id) {
        return deptLocService.getDeptLocById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DeptLocEntity> updateDeptLoc(@PathVariable Integer id, @RequestBody DeptLocEntity entity) {
        DeptLocEntity updated = deptLocService.updateDeptLoc(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}