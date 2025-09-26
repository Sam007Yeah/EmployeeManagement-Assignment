package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.WorksOnEntity;
import com.example.demo.Entities.WorksOnId;
import com.example.demo.Service.WorksOnService;

@RestController
@RequestMapping("/api/workson")
public class WorksOnController {

    @Autowired
    WorksOnService worksOnService;

    @GetMapping("/getAll")
    public ResponseEntity<List<WorksOnEntity>> getAllWorksOn() {
        return ResponseEntity.ok(worksOnService.getAllWorksOn());
    }

    @PostMapping("/add")
    public ResponseEntity<WorksOnEntity> addWorksOn(@RequestBody WorksOnEntity worksOn) {
        return ResponseEntity.ok(worksOnService.addWorksOn(worksOn));
    }

    @GetMapping("/getById")
    public ResponseEntity<WorksOnEntity> getWorksOnById(@RequestParam Integer employeeSsn,
            @RequestParam Integer projectNo) {
        WorksOnId id = new WorksOnId(employeeSsn, projectNo);
        return worksOnService.getWorksOnById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<WorksOnEntity> updateWorksOn(@RequestParam Integer employeeSsn,
            @RequestParam Integer projectNo, @RequestBody WorksOnEntity entity) {
        WorksOnId id = new WorksOnId(employeeSsn, projectNo);
        WorksOnEntity updated = worksOnService.updateWorksOn(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}