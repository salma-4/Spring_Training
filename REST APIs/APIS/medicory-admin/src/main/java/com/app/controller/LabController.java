package com.app.controller;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Lab;
import com.app.servicelayer.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/labs")
public class LabController {
    @Autowired
    LabService labService;


    @PostMapping
    public Lab addLab(@RequestBody Lab lab) throws EmptyRequestException, DataConflictException {
        return labService.insertLab(lab);

    }

    @PutMapping
    public Lab updateLab( @RequestBody Lab lab) throws EntityNotFoundException, DataConflictException, EmptyRequestException {
           return labService.updateLab(lab);
    }

    @GetMapping("/allLabs")
    public List<Lab> getAllLabs()throws EntityNotFoundException {
        List<Lab> labs= labService.getAllLabs();
        return labs;
    }

    @GetMapping("/labById/{id}")
    public Lab getLabById(@PathVariable Long id) throws EmptyRequestException, EntityNotFoundException {
      return labService.getLabById(id);
    }
    @GetMapping("/labsByName/{labName}")
    public List<Lab> getLabByName(@PathVariable String labName) throws EmptyRequestException, EntityNotFoundException{
        return labService.getLabsByName(labName);
    }
    @GetMapping("/labByEmail/{email}")
    public Lab getLabByEmail(@PathVariable String email) throws EmptyRequestException, EntityNotFoundException{
        return labService.getLabByEmail(email);
    }

    @DeleteMapping("/{id}")
    public String deleteLab(@PathVariable Long id)throws EmptyRequestException, EntityNotFoundException {
           labService.deleteLabById(id);
        return "Lab with id "+id+" deleted";
    }
}
