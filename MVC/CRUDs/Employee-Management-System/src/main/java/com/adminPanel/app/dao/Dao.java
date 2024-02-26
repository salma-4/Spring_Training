package com.adminPanel.app.dao;

import com.adminPanel.app.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.geom.QuadCurve2D;
import java.util.Collections;
import java.util.List;

@Repository
public class Dao implements  EmployeeDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Employee insert(Employee employee) {
        try{
            Session session =sessionFactory.getCurrentSession();
              session.persist(employee);
              return employee;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee delete(int id) {
        try{
            Session session =sessionFactory.getCurrentSession();
            Employee employee = session.get(Employee.class,id);
            session.delete(employee);
            return employee;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee searchByID(int employeeId) {
        try{
            Session session =sessionFactory.getCurrentSession();
            Employee emp = session.get(Employee.class,employeeId);
            return emp;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> searchByName(String employeeName) {
        try{
            Session session =sessionFactory.getCurrentSession();
            System.out.println("name :"+employeeName);
            Query query= session.createQuery("from Employee where name=:employeename ");
            query.setParameter("employeename",employeeName);
            System.out.println(query.list());
            return query.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee newEmployee) {
        try{
            Session session =sessionFactory.getCurrentSession();
            Employee oldEmployee = session.get(Employee.class,newEmployee.getId());
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setDepartment(newEmployee.getDepartment());
            oldEmployee.setEmail(newEmployee.getEmail());
            oldEmployee.setPosition(newEmployee.getPosition());
            oldEmployee.setSalary(newEmployee.getSalary());

            session.update(oldEmployee);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Employee");

            System.out.println((List<Employee>) query.list());
            return (List<Employee>) query.list();
        } catch (Exception ex) {
            // Log the error or handle it appropriately
            ex.printStackTrace();
            return Collections.emptyList(); // Return an empty list instead of null
        }
    }
}
