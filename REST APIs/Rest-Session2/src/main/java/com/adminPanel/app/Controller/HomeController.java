package com.adminPanel.app.Controller;

import com.adminPanel.app.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
 @RequestMapping(  "/")
    public  String showHome(){
     return "homePage";
 }
 @GetMapping( "/testApi")
 @ResponseBody
    public String test(){

     return "helloFromJson";
 } //http://localhost:8080/Rest-Session2/testApi
    @GetMapping("/testJson")
    @ResponseBody
    public Student fromPojotoJson(){
     return new Student(1,"salma",false);
    } //http://localhost:8080/Rest-Session2/testJson
     @GetMapping("/testPojo")
    @ResponseBody
    public void fromJsonToPojo(@RequestBody Student student){
         System.out.println(student);

    }//http://localhost:8080/Rest-Session2/testPojo

    @GetMapping("/getAllStudent")
    @ResponseBody
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Collections.addAll(studentList,new Student(1,"salma",true),new Student(2,"sara",false));
        return  studentList;
    }
    //http://localhost:8080/Rest-Session2/getAllStudent

}
