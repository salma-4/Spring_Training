package com.app.controller;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Owner;
import com.app.servicelayer.OwnerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Api to handle Owners as an admin")
@RequestMapping("/admin/owner")

public class OwnerController {
 @Autowired
 OwnerService ownerService;


    @GetMapping("/")
    public String test(){
        return "200 ok";
    }


    @GetMapping("/allOwners")
    public List<Owner> getAllOwners() throws EntityNotFoundException, EmptyRequestException {

     List<Owner> ownerList = ownerService.getAllOwners();
        System.out.println(ownerList);
        return ownerList;
    }



    @DeleteMapping("/{id}")
    public String deleteOwnerById(@PathVariable Long id) throws EmptyRequestException, EntityNotFoundException {
        ownerService.deleteOwnerById(id);
        return ("Owner with ID " + id + " has been deleted.");
    }


    @GetMapping(value = "/ownerByid/{id}")
    public Owner getOwnerById(@PathVariable Long id) throws EmptyRequestException, EntityNotFoundException {
        Owner owner = ownerService.getOwnerById(id);
        return owner;
    }
    @GetMapping("/ownerByName")
    public List<Owner> getOwnersByName(@RequestParam String fname,@RequestParam String lname) throws EmptyRequestException, EntityNotFoundException {

        return ownerService.getOwnersByName(fname,lname);
    }


    @GetMapping("/ownerByEmail")
    public Owner getOwnerByEmail(@RequestParam String email) throws EmptyRequestException, EntityNotFoundException {
        return  ownerService.getOwnerByEmail(email);
    }


    @PostMapping
    public  Owner insertOwner(@RequestBody Owner owner) throws EmptyRequestException, DataConflictException {
        return ownerService.insertOwner(owner);

    }


    @PutMapping
    public Owner updateOwner(@RequestBody Owner owner) throws DataConflictException, EntityNotFoundException {
        return ownerService.updateOwner(owner);
    }
}
