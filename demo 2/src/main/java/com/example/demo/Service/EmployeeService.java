package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    public ResponseEntity<String> addEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee added successfully");
    }

    public ResponseEntity<EmployeeEntity> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeOpt = employeeRepository.findById(id);
        return employeeOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<EmployeeEntity> updateEmployee(Long id, EmployeeEntity entity) {
        Optional<EmployeeEntity> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            EmployeeEntity existingEmployee = employeeOpt.get();
            existingEmployee.setName(entity.getName());
            existingEmployee.setAddress(entity.getAddress());
            existingEmployee.setBirthdate(entity.getBirthdate());
            existingEmployee.setDepartment(entity.getDepartment());
            existingEmployee.setGender(entity.getGender());
            existingEmployee.setSupervisor(entity.getSupervisor());
            existingEmployee.setSalary(entity.getSalary());
            existingEmployee.setProject(entity.getProject());
            employeeRepository.save(existingEmployee);
            return ResponseEntity.ok(existingEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}