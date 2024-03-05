package com.app.servicelayer.owner;

import com.app.dao.owner.OwnerDao;
import com.app.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OwnerServiceIMPL implements OwnerService{
    @Autowired
    OwnerDao ownerDao;
    @Override
    public Owner insertOwner(Owner owner) {
       if(owner!=null)
           return  ownerDao.insertOwner(owner);
       else
           throw new NullPointerException("error");
    }

    @Override
    public void deleteOwnerById(Long ownerId) {
        if(ownerId>0)
            ownerDao.deleteOwnerById(ownerId);

    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        if(ownerId>0)
        return ownerDao.getOwnerById(ownerId);
        else
            throw new RuntimeException();
    }

    @Override
    public List<Owner> getOwnersByName(String firstName, String middleName) {
       return ownerDao.getOwnersByName(firstName,middleName);
    }

    @Override
    public Owner getOwnerByEmail(String email) {
        return ownerDao.getOwnerByEmail(email);
    }

    @Override
    public Owner updateOwner(Owner newOwner) {
       return ownerDao.updateOwner(newOwner);
    }

    @Override
    public List<Owner> getAllOwners() {
      return ownerDao.getAllOwners();
    }
}
