package com.app.controller;

import com.app.dao.ClinicDao;
import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Clinic;
import com.app.servicelayer.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) throws EmptyRequestException, DataConflictException {
        Clinic newClinic = clinicService.insertClinic(clinic);
        return newClinic;
    }

    @PutMapping
    public Clinic updateClinic( @RequestBody Clinic clinic) throws EntityNotFoundException, DataConflictException{
        Clinic updatedClinic = clinicService.updateClinic(clinic);
     return  updatedClinic;
    }

    @GetMapping("/allClinics")
    public List<Clinic> getAllClinics()throws EntityNotFoundException {
        List<Clinic> clinics = clinicService.getAllClinics();
       return clinics;
    }

    @GetMapping("/clinicById/{id}")
    public Clinic getClinicById(@PathVariable Long id) throws EmptyRequestException, EntityNotFoundException {
        Clinic clinic = clinicService.getClinicById(id);
          return clinic;
    }
    @GetMapping("/clinicsByName/{clinicName}")
    public List<Clinic> getClinicByName(@PathVariable String clinicName) throws EmptyRequestException, EntityNotFoundException{
        return clinicService.getClinicsBName(clinicName);

    }
    @GetMapping("/clinicByEmail/{email}")
    public Clinic getClinicByEmail(@PathVariable String email) throws EmptyRequestException, EntityNotFoundException{
        Clinic clinic = clinicService.getClinicByEmail(email);
        return clinic;
    }

    @DeleteMapping("/{id}")
    public String deleteClinic(@PathVariable Long id)throws EmptyRequestException, EntityNotFoundException {
        clinicService.deleteClinicById(id);
        return "Clinic with id "+id+" deleted";
    }
}