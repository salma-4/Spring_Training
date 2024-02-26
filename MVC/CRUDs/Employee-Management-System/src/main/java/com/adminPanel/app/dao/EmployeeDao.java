package com.adminPanel.app.dao;
 import com.adminPanel.app.model.Employee;

 import java.util.List;

public interface EmployeeDao {

    public Employee insert(Employee employees);
    public Employee delete(int id);

    public Employee searchByID(int employeeId);

    public List<Employee> searchByName(String employeeName);

    public void update(Employee newEmployee);
    
    public List<Employee> getAllEmployee();
}
