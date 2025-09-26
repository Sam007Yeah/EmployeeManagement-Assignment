package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class DepartmentEntity {
    @Id
    private Integer deptNo;

    private String deptName;

    @OneToOne
    @JoinColumn(name = "manager_ssn", referencedColumnName = "ssn")
    private EmployeeEntity manager;

    @Temporal(TemporalType.DATE)
    private Date managerStartDate;

    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;

    @OneToMany(mappedBy = "department")
    private List<DeptLocEntity> locations;

    @OneToMany(mappedBy = "controllingDept")
    private List<ProjectEntity> projects;

    // Getters and Setters
    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getManagerSsn() {
        return manager.getSsn();
    }

    public void setManagerSsn(Integer managerSsn) {
        if (this.manager != null) {
            this.manager.setSsn(managerSsn);
        }
    }

    public Date getManagerStartDate() {
        return managerStartDate;
    }

    public void setManagerStartDate(Date managerStartDate) {
        this.managerStartDate = managerStartDate;
    }

    public EmployeeEntity getManager() {
        return this.manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "DepartmentEntity [deptNo=" + deptNo + ", deptName=" + deptName + ", managerSsn=" + manager.getSsn()
                + ", managerStartDate=" + managerStartDate + "]";
    }

}
