package com.adminPanel.app.controller;


import com.adminPanel.app.dao.Dao;
import com.adminPanel.app.model.Employee;
import com.adminPanel.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping( value = "/")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);

       /*test
        for(int i=0;i<4;i++){
            Employee emp = new Employee();
            emp=employees.get(i);
            System.out.println(emp.getName());
        }*/
        return "homePage"; // JSP view name
    }
     //Show and Update
    @GetMapping(value = "/showDetails")
    public String  showEmployeeDetails(@RequestParam("employeeId") int empId,Model model){

     Employee employee=employeeService.searchByID(empId);
      model.addAttribute("detailedEmployee",employee);;
        return "showDetails";

    }

    @PostMapping(value = "/updateEmployeeData")
    public String updateEmployeeData(@ModelAttribute("detailedEmployee") Employee employee) {
        System.out.println(employee.getName()+employee.getDepartment());
        employeeService.update(employee);
        return "redirect:/"; // Redirect to the home page after updating
    }
    //update +^
    @GetMapping("/updateEmployee")
    public String showUpdateForm(@RequestParam("employeeId") int id ,  Model model) {

        Employee employee = employeeService.searchByID(id);
        model.addAttribute("detailedEmployee",employee);
        return "updateDataForm";


    }


        //  add
    @GetMapping("/addEmployee")
    public String showAddNewEmployee(Model model)
    {
        model.addAttribute("employeeModel" , new Employee());
        return "addEmployeeForm";
    }
    @PostMapping(value = "/processAddEmployee")
    public String processAddEmployee(@ModelAttribute("employeeModel") Employee employee , BindingResult bindingResult , Model employeeModel){
        if(bindingResult.hasErrors())
            return "addEmployeeForm";

        employeeService.insert(employee);
        List<Employee> employees = employeeService.getAllEmployee();
        employeeModel.addAttribute("employees", employees);
        return "redirect:/";
    }
    //delete
    @GetMapping("/deleteEmployee")
    public String deleteCustomer(@RequestParam("employeeId") int id) {
        employeeService.delete(id);
        return "redirect:/";
    }
    //search
        @GetMapping("/searchEmployeeName")
    public String searchProducts(@RequestParam("searchKey") String searchKey , Model model)
    {

        List<Employee> employees = employeeService.searchByName(searchKey);
        System.out.println(employees);
        model.addAttribute("employees", employees);
        return "homePage";
    }
    @GetMapping("/searchEmployeeId")
    public String searchProducts(@RequestParam("id") int id, Model model)
    {

       Employee employees = employeeService.searchByID(id);
       List<Employee> employeeList=new ArrayList<>();
       employeeList.add(employees);
        model.addAttribute("employees", employeeList);
        System.out.println(employees);
        return "homePage";
    }

}

