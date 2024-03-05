package com.app.servicelayer.owner;

import com.app.model.Owner;

import java.util.List;

public interface OwnerService {

    public Owner insertOwner(Owner owner);

    public void deleteOwnerById(Long ownerId);

    public Owner getOwnerById(Long ownerId);

    public List<Owner> getOwnersByName(String firstName, String middleName);

    public Owner getOwnerByEmail(String email);

    public Owner updateOwner(Owner newOwner);

    public List<Owner> getAllOwners();
}