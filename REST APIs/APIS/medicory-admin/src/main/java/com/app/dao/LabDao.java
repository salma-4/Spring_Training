package com.app.dao;

import com.app.model.Lab;

import java.util.List;

public interface LabDao {

    public Lab insertLab(Lab lab);
    public Lab updateLab(Lab newLab);
    public List<Lab> getAllLabs();
    public Lab getLabById(Long id);
    public Lab getLabByEmail(String email);
    public List<Lab> getLabsByName(String labName);
    public void deleteLabById(Long id);

}
