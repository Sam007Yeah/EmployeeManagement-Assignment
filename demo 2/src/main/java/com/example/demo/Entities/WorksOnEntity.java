package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@IdClass(WorksOnId.class)
public class WorksOnEntity {
    @Id
    @Column(name = "employee_ssn")
    private Integer employeeSsn;

    @Id
    @Column(name = "project_no")
    private Integer projectNo;

    @ManyToOne
    @JoinColumn(name = "employee_ssn", insertable = false, updatable = false)
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "project_no", insertable = false, updatable = false)
    private ProjectEntity project;

    private Float hoursWorked;

    // Getters and Setters
    public Integer getEmployeeSsn() {
        return employeeSsn;
    }

    public void setEmployeeSsn(Integer employeeSsn) {
        this.employeeSsn = employeeSsn;
    }

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public Float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}