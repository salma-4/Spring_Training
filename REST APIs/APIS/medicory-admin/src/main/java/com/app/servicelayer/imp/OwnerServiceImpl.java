package com.app.servicelayer.imp;

import com.app.dao.OwnerDao;
import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Owner;
import com.app.servicelayer.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerDao ownerDao;

    @Override
    public Owner insertOwner(Owner owner) throws EmptyRequestException, DataConflictException {
        if (owner != null) {
            Owner checkOwner = ownerDao.getOwnerByEmail(owner.getUser().getEmail());
            if (checkOwner != null)
                throw new DataConflictException("Owner email already exists");
            else
                return ownerDao.insertOwner(owner);
        } else
            throw new EmptyRequestException("Invalid data entered, please check it!");
    }

    @Override
    public Owner updateOwner(Owner newOwner) throws EntityNotFoundException, DataConflictException {
        return ownerDao.updateOwner(newOwner);
    }

    @Override
    public List<Owner> getAllOwners() throws EntityNotFoundException {
        List<Owner> ownerList = ownerDao.getAllOwners();
        if (ownerList.isEmpty())
            throw new EntityNotFoundException("There are no owners to be shown");
        else
            return ownerList;
    }

    @Override
    public Owner getOwnerById(Long id) throws EmptyRequestException, EntityNotFoundException {
        if (id > 0) {
            Owner owner = ownerDao.getOwnerById(id);
            if (owner != null)
                return owner;
            else
                throw new EntityNotFoundException("There is no owner with ID: " + id);
        } else {
            throw new EmptyRequestException("Invalid ID, please check it!");
        }
    }

    @Override
    public List<Owner> getOwnersByName(String firstName, String middleName) throws EmptyRequestException, EntityNotFoundException {
        if (firstName != null && middleName != null) {
            List<Owner> ownerList = ownerDao.getOwnersByName(firstName, middleName);
            if (ownerList.isEmpty())
                throw new EntityNotFoundException("There are no owners with the provided name");
            else
                return ownerList;
        } else {
            throw new EmptyRequestException("Invalid name provided, please check it!");
        }
    }

    @Override
    public Owner getOwnerByEmail(String email) throws EntityNotFoundException, EmptyRequestException {
        if (email != null && !email.isEmpty()) {
            Owner owner = ownerDao.getOwnerByEmail(email);
            if (owner != null)
                return owner;
            else
                throw new EntityNotFoundException("There is no owner with the provided email");
        } else {
            throw new EmptyRequestException("Invalid email provided, please check it!");
        }
    }

    @Override
    public void deleteOwnerById(Long id) throws EntityNotFoundException, EmptyRequestException {
        if (id > 0) {
            Owner owner = ownerDao.getOwnerById(id);
            if (owner != null)
                ownerDao.deleteOwnerById(id);
            else
                throw new EntityNotFoundException("There is no owner with ID: " + id);
        } else {
            throw new EmptyRequestException("Invalid ID provided, please check it!");
        }
    }
}