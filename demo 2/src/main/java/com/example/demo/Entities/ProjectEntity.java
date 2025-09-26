package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class ProjectEntity {
    @Id
    private Integer projectNo;

    private String projectName;

    private String projectLoc;

    @ManyToOne
    @JoinColumn(name = "controlling_dept")
    private DepartmentEntity controllingDept;

    @OneToMany(mappedBy = "project")
    private List<WorksOnEntity> worksOn;

    // Getters and Setters
    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLoc() {
        return projectLoc;
    }

    public void setProjectLoc(String projectLoc) {
        this.projectLoc = projectLoc;
    }

    public Integer getControllingDept() {
        return controllingDept.getDeptNo();
    }

    public void setControllingDept(DepartmentEntity controllingDept) {
        this.controllingDept = controllingDept;
    }

    @Override
    public String toString() {
        return "ProjectEntity [projectNo=" + projectNo + ", projectName=" + projectName + ", projectLoc=" + projectLoc
                + ", controllingDept=" + controllingDept + "]";
    }

    public Object getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

}
