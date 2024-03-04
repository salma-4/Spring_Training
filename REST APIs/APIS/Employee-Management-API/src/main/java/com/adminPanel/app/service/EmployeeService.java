package com.adminPanel.app.service;

import com.adminPanel.app.exception.EmployeeNotFoundException;
import com.adminPanel.app.exception.EmptyDataException;
import com.adminPanel.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee insert(Employee employees) throws EmptyDataException;
    public Employee delete(int id) throws EmployeeNotFoundException;

    public Employee searchByID(int employeeId) throws EmployeeNotFoundException;

    public List<Employee> searchByName(String employeeName) throws EmployeeNotFoundException;

    public void update(Employee newEmployee);

    public List<Employee> getAllEmployee();
}
