package net.demo.springboot.controller;

import net.demo.springboot.exception.ResourceNotFoundException;
import net.demo.springboot.model.Employee;
import net.demo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    public EmployeeRepository employeerepository;
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeerepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeerepository.save(employee);
    }

    //build get employee by Id rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeerepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id:"+ id));
        return ResponseEntity.ok(employee);
    }

    //Building Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeerepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id"+ id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeerepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeerepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:" + id));
        employeerepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
