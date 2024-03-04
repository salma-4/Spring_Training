package com.adminPanel.app.controller;


import com.adminPanel.app.exception.EmployeeNotFoundException;
import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.model.Employee;
import com.adminPanel.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController // = ResponseBody+Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping( value = "/")
    @ApiIgnore
    public String test() {
        return "200  OK ";
    }
    @PostMapping("/employees")
    public Employee insertEmployee(@RequestBody Employee employee)throws EmptyDataException {
        employeeService.insert(employee);
        return employee;
    }
    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);
        return "update employee eith id : "+employee.getId();

    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
       List<Employee> employeeList= employeeService.getAllEmployee();
       return  employeeList;
    }
    @GetMapping("/employees/employee")
    public Employee getEmployeeById(@RequestParam int employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeService.searchByID(employeeId);
        return  employee;
    }
    @GetMapping("employees/employeeByName")
    public List<Employee> getEmployeeByName(@RequestParam String name) throws EmployeeNotFoundException {
      List<Employee> employee = employeeService.searchByName(name);
        return  employee;
    }
    @DeleteMapping("/employees")
    public String deleteEmployeeById(@RequestParam int employeeId) throws EmployeeNotFoundException{
        employeeService.delete(employeeId);
        return "employee with id "+employeeId+" deleted";
    }


}

