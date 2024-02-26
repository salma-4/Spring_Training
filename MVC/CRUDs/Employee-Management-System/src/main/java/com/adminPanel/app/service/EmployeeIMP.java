package com.adminPanel.app.service;

import com.adminPanel.app.dao.EmployeeDao;
import com.adminPanel.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class EmployeeIMP  implements  EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee insert(Employee employees) {
        if(!employees.getName().isEmpty()) {
            employeeDao.insert(employees);
            return employees;
        }
        else
            throw new NullPointerException();
    }

    @Override
    public Employee delete(int id) {
       return employeeDao.delete(id);
    }

    @Override
    public Employee searchByID(int employeeId) {
      return employeeDao.searchByID(employeeId);
    }

    @Override
    public List<Employee> searchByName(String employeeName) {
        try {
            return(List<Employee>) employeeDao.searchByName(employeeName);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee newEmployee) {
        Employee employee = employeeDao.searchByID(newEmployee.getId());

        if (employee != null)
        {
            employeeDao.update(newEmployee);
        }
        else
            throw new NullPointerException();

    }
  @Transactional
    @Override
    public List<Employee> getAllEmployee() {
        try {
            return (List<Employee>) employeeDao.getAllEmployee();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
      return Collections.emptyList();
    }
}
