package com.app.servicelayer;

import com.app.exceptions.DataConflictException;
import com.app.exceptions.EmptyRequestException;
import com.app.exceptions.EntityNotFoundException;
import com.app.model.Owner;

import java.util.List;

public interface OwnerService {


        public Owner insertOwner(Owner owner) throws EmptyRequestException, DataConflictException;

        public void deleteOwnerById(Long ownerId) throws EntityNotFoundException, EmptyRequestException;

        public Owner getOwnerById(Long ownerId) throws EmptyRequestException, EntityNotFoundException;

        public List<Owner> getOwnersByName(String firstName, String middleName) throws EmptyRequestException, EntityNotFoundException;

        public Owner getOwnerByEmail(String email) throws EntityNotFoundException, EmptyRequestException;

        public Owner updateOwner(Owner newOwner) throws EntityNotFoundException, DataConflictException;

        public List<Owner> getAllOwners()throws EntityNotFoundException, EmptyRequestException;

}
