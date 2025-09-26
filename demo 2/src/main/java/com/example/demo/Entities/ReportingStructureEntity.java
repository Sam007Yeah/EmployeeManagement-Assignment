package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
@IdClass(ReportingStructureId.class)
public class ReportingStructureEntity {
    @Id
    @Column(name = "manager_ssn")
    private Integer managerSsn;

    @Id
    @Column(name = "employee_ssn")
    private Integer employeeSsn;

    @ManyToOne
    @JoinColumn(name = "manager_ssn", insertable = false, updatable = false)
    private EmployeeEntity manager;

    @ManyToOne
    @JoinColumn(name = "employee_ssn", insertable = false, updatable = false)
    private EmployeeEntity employee;

    // Getters and Setters
    public Integer getManagerSsn() {
        return managerSsn;
    }

    public void setManagerSsn(Integer managerSsn) {
        this.managerSsn = managerSsn;
    }

    public Integer getEmployeeSsn() {
        return employeeSsn;
    }

    public void setEmployeeSsn(Integer employeeSsn) {
        this.employeeSsn = employeeSsn;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}