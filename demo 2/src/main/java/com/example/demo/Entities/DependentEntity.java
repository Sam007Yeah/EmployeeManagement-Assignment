package com.example.demo.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DependentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ssn")
    private EmployeeEntity employee;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    private Character gender;

    private String relationship;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Removed getSsn and setSsn methods as there is no 'ssn' field

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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DependentEntity [id=" + id + ", employee=" + employee + ", name=" + name + ", birthdate=" + birthdate
                + "Gender=" + gender + ", relationship=" + relationship + "]";
    }
}
