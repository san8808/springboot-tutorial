package com.codingshuttle.sankalpProject.tutorial.controllers;

//Operations
//GET /employees
//POST /employees
//DELETE /employees

import com.codingshuttle.sankalpProject.tutorial.dto.EmployeeDTO;
import com.codingshuttle.sankalpProject.tutorial.repositories.EmployeeRepository;
import com.codingshuttle.sankalpProject.tutorial.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeesById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path="/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }



}
