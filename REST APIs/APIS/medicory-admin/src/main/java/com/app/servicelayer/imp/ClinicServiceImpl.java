package com.app.servicelayer.imp;

import com.app.dao.ClinicDao;
import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Clinic;
import com.app.servicelayer.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    ClinicDao clinicDao;

    @Override
    public Clinic insertClinic( Clinic clinic) throws EmptyRequestException, DataConflictException {
        if (clinic != null) {
            Clinic checkClinic = clinicDao.getClinicByEmail(clinic.getUser().getEmail());
            if (checkClinic != null)
                throw new DataConflictException("Owner email already exists");
            else
                return clinicDao.insertClinic(clinic);
        } else{
            System.out.println("in insert");
            throw new EmptyRequestException("Invalid data entered, please check it!");
        }
    }

    @Override
    public Clinic updateClinic(Clinic newClinic) throws EntityNotFoundException, DataConflictException {
        return clinicDao.updateClinic(newClinic);
    }

    @Override
    public List<Clinic> getAllClinics() throws EntityNotFoundException {
        List<Clinic> clinicList = clinicDao.getAllClinics();
        if (clinicList.isEmpty())
            throw new EntityNotFoundException("There are no clinics to be shown");
        else
            return clinicList;
    }

    @Override
    public Clinic getClinicById(Long id) throws EmptyRequestException, EntityNotFoundException {
        if (id > 0) {
          Clinic clinic = clinicDao.getClinicById(id);
          if(clinic!=null){
              return clinic;
          }else
              throw new EntityNotFoundException("There is no clinic with ID: " + id);

        }
        else{
            throw new EmptyRequestException("Invalid ID, please check it!");
        }
        }



    @Override
    public List<Clinic> getClinicsBName(String firstName) throws EmptyRequestException, EntityNotFoundException {
        if (firstName != null && firstName!="") {
            List<Clinic> clinicList = clinicDao.getClinicsBName(firstName);
            if (clinicList.isEmpty())
                throw new EntityNotFoundException("There are no clinics with the provided name");
            else
                return clinicList;
        } else {
            throw new EmptyRequestException("Invalid name provided, please check it!");
        }
    }

    @Override
    public Clinic getClinicByEmail(String email) throws EntityNotFoundException, EmptyRequestException {
        if (email != null && !email.isEmpty()) {
            Clinic clinic = clinicDao.getClinicByEmail(email);
            if (clinic != null)
                return clinic;
            else
                throw new EntityNotFoundException("There is no clinic with the provided email");
        } else {
            throw new EmptyRequestException("Invalid email provided, please check it!");
        }
    }

    @Override
    public void deleteClinicById(Long id) throws EntityNotFoundException, EmptyRequestException {
        if (id > 0) {
           Clinic clinic = clinicDao.getClinicById(id);
            if (clinic != null)
                clinicDao.deleteClinicById(id);
            else
                throw new EntityNotFoundException("There is no clinic with ID: " + id);
        } else
            throw new EmptyRequestException("Invalid ID provided, please check it!");

    }
}