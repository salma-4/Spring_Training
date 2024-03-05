package com.app.controller;

import com.app.model.Owner;
import com.app.servicelayer.owner.OwnerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Api to handle products")
public class OwnerController {
 @Autowired
    OwnerService ownerService;
    @GetMapping("/")
    public String test(){
        return "200 ok";
    }
    @GetMapping("/admin/owners")
    public List<Owner> getAllOwners(){

     List<Owner> ownerList =ownerService.getAllOwners();
        System.out.println(ownerList);
        return ownerList;
    }

    @DeleteMapping("/admin/owners/{id}")
    public String deleteOwnerById(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return ("Owner with ID " + id + " has been deleted.");
    }


    @GetMapping(value = "/admin/owners/{id}")
    public Owner getOwnerById(@PathVariable Long id){
        Owner owner = ownerService.getOwnerById(id);
        return owner;
    }
    @GetMapping("/admin/owners")
    public List<Owner> getOwnersByName(@RequestParam String fname,@RequestParam String lname){

        return ownerService.getOwnersByName(fname,lname);
    }
}
