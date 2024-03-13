package com.app.servicelayer;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Lab;

import java.util.List;

public interface LabService {
    public Lab insertLab(Lab lab) throws DataConflictException, EmptyRequestException, EmptyRequestException;
    public Lab updateLab(Lab newLab) throws EntityNotFoundException, EntityNotFoundException, DataConflictException, EmptyRequestException;
    public List<Lab> getAllLabs() throws EntityNotFoundException;
    public Lab getLabById(Long id) throws EmptyRequestException, EntityNotFoundException;
    public Lab getLabByEmail(String email) throws EntityNotFoundException, EmptyRequestException;
    public List<Lab> getLabsByName(String labName) throws EmptyRequestException, EntityNotFoundException;
    public void deleteLabById(Long id) throws EntityNotFoundException, EmptyRequestException;
}
