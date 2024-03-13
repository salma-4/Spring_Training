package com.app.servicelayer.imp;

import com.app.dao.LabDao;
import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Lab;
import com.app.servicelayer.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class LabServiceImpl implements LabService {
    @Autowired
    LabDao labDao;

    @Override
    public Lab insertLab(Lab lab) throws EmptyRequestException, DataConflictException {
        if (lab != null) {
            Lab checkEmail = labDao.getLabByEmail(lab.getUser().getEmail());
            if (checkEmail != null) {
                throw new DataConflictException("Lab email already exists");
            } else {
                return labDao.insertLab(lab);
            }
        } else {
            throw new EmptyRequestException("Invalid data entered, please check it!");
        }
    }

    @Override
    public Lab updateLab(Lab newLab) throws EntityNotFoundException, DataConflictException, EmptyRequestException {
        if (newLab != null) {
            Lab existingLab = labDao.getLabById(newLab.getId());
            if (existingLab == null) {
                throw new EntityNotFoundException("Lab not found with ID: " + newLab.getId());
            }
            return labDao.updateLab(newLab);
        } else {
            throw new EmptyRequestException("Invalid data entered, please check it!");
        }
    }

    @Override
    public List<Lab> getAllLabs() throws EntityNotFoundException {
        List<Lab> labList = labDao.getAllLabs();
        if (labList.isEmpty()) {
            throw new EntityNotFoundException("No labs found");
        }
        return labList;
    }

    @Override
    public Lab getLabById(Long id) throws EmptyRequestException, EntityNotFoundException {
        if (id <= 0) {
            throw new EmptyRequestException("Invalid ID provided, please check it!");
        } else {
            Lab lab = labDao.getLabById(id);
            if (lab == null) {
                throw new EntityNotFoundException("Lab not found with ID: " + id);
            }
            return lab;
        }
    }

    @Override
    public Lab getLabByEmail(String email) throws EntityNotFoundException, EmptyRequestException {
        if (email != null && !email.isEmpty()) {
          Lab lab  = labDao.getLabByEmail(email);
            if (lab!= null)
                return lab;
            else
                throw new EntityNotFoundException("There is no lab with the provided email");
        } else {
            throw new EmptyRequestException("Invalid email provided, please check it!");
        }
    }

    @Override
    public List<Lab> getLabsByName(String labName) throws EmptyRequestException, EntityNotFoundException {
        if (labName == null || labName.isEmpty()) {
            throw new EmptyRequestException("Invalid lab name provided, please check it!");
        } else {
            List<Lab> labList = labDao.getLabsByName(labName);
            if (labList.isEmpty()) {
                throw new EntityNotFoundException("No labs found with name: " + labName);
            }
            return labList;
        }
    }

    @Override
    public void deleteLabById(Long id) throws EntityNotFoundException, EmptyRequestException {
        if (id <= 0) {
            throw new EmptyRequestException("Invalid ID provided, please check it!");
        } else {
            Lab lab = labDao.getLabById(id);
            if (lab == null) {
                throw new EntityNotFoundException("Lab not found with ID: " + id);
            }
            labDao.deleteLabById(id);
        }
    }
}