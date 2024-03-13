package com.app.dao;

import com.app.model.Clinic;

import java.util.List;

public interface ClinicDao {
     Clinic insertClinic(Clinic clinic);
     Clinic updateClinic(Clinic newClinic);
     List<Clinic> getAllClinics();
     Clinic getClinicById(Long id);
     List<Clinic> getClinicsBName(String name);
     Clinic getClinicByEmail(String email);
     void deleteClinicById(Long id);


}
