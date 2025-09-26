package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entities.ProjectEntity;
import com.example.demo.Entities.DepartmentEntity;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Repository.DepartmentRepository;

@Service
public class ProjectService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectEntity addProject(ProjectEntity project) {
        return projectRepository.save(project);
    }

    public Optional<ProjectEntity> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    public ProjectEntity updateProject(Integer id, ProjectEntity updatedProject) {
        Optional<ProjectEntity> existingProjectOpt = projectRepository.findById(id);
        if (existingProjectOpt.isPresent()) {
            ProjectEntity existingProject = existingProjectOpt.get();
            existingProject.setProjectName(updatedProject.getProjectName());
            DepartmentEntity dept = departmentRepository.findById(updatedProject.getControllingDept())
                    .orElse(null);
            existingProject.setControllingDept(dept);
            return projectRepository.save(existingProject);
        } else {
            return null;
        }
    }
}