package com.app.servicelayer;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Clinic;

import java.util.List;

public interface ClinicService {
    public Clinic insertClinic(Clinic clinic) throws EmptyRequestException, DataConflictException;
    public Clinic updateClinic(Clinic newClinic) throws EntityNotFoundException, DataConflictException;
    public List<Clinic> getAllClinics() throws EntityNotFoundException;
    public Clinic getClinicById(Long id) throws EmptyRequestException, EntityNotFoundException;
    public List<Clinic> getClinicsBName(String name) throws EntityNotFoundException, EmptyRequestException;
    public Clinic getClinicByEmail(String email) throws EntityNotFoundException, EmptyRequestException;
    public void  deleteClinicById(Long id) throws EntityNotFoundException, EmptyRequestException;
}
