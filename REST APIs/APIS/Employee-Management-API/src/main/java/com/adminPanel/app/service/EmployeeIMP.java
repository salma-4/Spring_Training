package com.adminPanel.app.service;

import com.adminPanel.app.dao.EmployeeDao;
import com.adminPanel.app.exception.EmployeeNotFoundException;
import com.adminPanel.app.exception.EmptyDataException;
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
    public Employee insert(Employee employee) throws EmptyDataException {
        if (isValidEmployee(employee)) {
            return employeeDao.insert(employee);
        } else {
            throw new EmptyDataException("Employee data is invalid,may be you forgot to enter an item ");
        }
    }

    @Override
    public Employee delete(int id) throws EmployeeNotFoundException {
        if (id <= 0)
            throw new EmployeeNotFoundException("this id is invalid");
        else {
            Employee employee = employeeDao.searchByID(id);
            if (employee == null)
                throw new EmployeeNotFoundException("there is no employee in this id " + id);
            else
           return  employeeDao.delete(id);
        }
    }
    @Override
    public Employee searchByID(int employeeId) throws EmployeeNotFoundException {
        if(employeeId<=0 )
            throw new EmployeeNotFoundException("this id is invalid");
        else {
          Employee employee= employeeDao.searchByID(employeeId);
            if(employee==null)
                throw new EmployeeNotFoundException("there is no employee in this id "+employeeId);
            else
                return employee;
        }
    }

    @Override
    public List<Employee> searchByName(String employeeName) throws EmployeeNotFoundException{
        if(employeeName.isEmpty() ||employeeName=="")
            throw new EmployeeNotFoundException("where is the name");
        else {
           List<Employee> employee= employeeDao.searchByName(employeeName);
            if(employee.isEmpty())
                throw new EmployeeNotFoundException("there is no employee in this name "+employeeName );
            else
                return employee;
        }

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
    private boolean isValidEmployee(Employee employee) {

        if(!(employee.getName().isEmpty()||(employee.getPosition().isEmpty())|| (employee.getSalary()==0)|| (employee.getEmail().isEmpty())|| (employee.getDepartment().isEmpty())))
            return true;
        else
            return false;
    }
}
