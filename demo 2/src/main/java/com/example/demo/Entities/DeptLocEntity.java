package com.example.demo.Entities;

import jakarta.persistence.*;

@Entity
public class DeptLocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dept_no")
    private DepartmentEntity department;

    private String location;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptNo() {
        return department.getDeptNo();
    }

    public void setDeptNo(Integer deptNo) {
        if (this.department == null) {
            this.department = new DepartmentEntity();
        }
        this.department.setDeptNo(deptNo);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DepartmentEntity getDepartment() {
        return this.department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DeptLocEntity [id=" + id + ", deptNo=" + (department != null ? department.getDeptNo() : null)
                + ", location=" + location + "]";
    }
}