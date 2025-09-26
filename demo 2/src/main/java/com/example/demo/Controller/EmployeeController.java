package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity employee) {
        logger.info("Adding new employee: " + employee.toString());
        return employeeService.addEmployee(employee);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<EmployeeEntity> getMethodName(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity entity) {
        logger.info("Updating employee with id: " + id);
        return employeeService.updateEmployee(id, entity);
    }

}
