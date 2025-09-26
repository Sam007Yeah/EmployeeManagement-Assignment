package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entities.ProjectEntity;
import com.example.demo.Service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectEntity> addProject(@RequestBody ProjectEntity project) {
        return ResponseEntity.ok(projectService.addProject(project));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Integer id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectEntity> updateProject(@PathVariable Integer id, @RequestBody ProjectEntity entity) {
        ProjectEntity updated = projectService.updateProject(id, entity);
        if (updated != null)
            return ResponseEntity.ok(updated);
        else
            return ResponseEntity.notFound().build();
    }
}