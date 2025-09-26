package com.example.demo.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class EmployeeEntity {
    @Id
    private Integer ssn;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    private String address;

    private Float salary;

    private Character gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "supervisor_ssn")
    private EmployeeEntity supervisor;

    @ManyToOne
    @JoinColumn(name = "project_no")
    private ProjectEntity project;

    @OneToMany(mappedBy = "employee")
    private List<DependentEntity> dependents;

    @OneToMany(mappedBy = "manager")
    private List<ReportingStructureEntity> managedEmployees;

    @OneToMany(mappedBy = "employee")
    private List<ReportingStructureEntity> managers;

    @OneToMany(mappedBy = "employee")
    private List<WorksOnEntity> worksOn;

    // Getters and Setters

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public DepartmentEntity getDepartment() {
        return this.department;
    }

    public EmployeeEntity getSupervisor() {
        return this.supervisor;
    }

    public ProjectEntity getProject() {
        return this.project;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public void setSupervisor(EmployeeEntity supervisor) {
        this.supervisor = supervisor;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    // Removed unused getters and setters for departmentId, supervisorSsn, and
    // projectNo

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "ssn=" + ssn +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", department=" + (department != null ? department.getDeptNo() : null) +
                ", supervisor=" + (supervisor != null ? supervisor.getSsn() : null) +
                ", project=" + (project != null ? project.getProjectNo() : null) +
                '}';
    }
}
