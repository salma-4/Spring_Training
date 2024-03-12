package com.app.dao;

import com.app.model.Clinic;

import java.util.List;

public interface ClinicDao {
    public Clinic insertClinic(Clinic clinic);
    public Clinic updateClinic(Clinic newClinic);
    public List<Clinic> getAllClinics();
    public Clinic getClinicById(Long id);
    public List<Clinic> getClinicsBName(String name);
    public Clinic getClinicByEmail(String email);
    public void deleteClinicById(Long id);


}
