package com.app.dao.owner;

import com.app.model.Owner;
import com.app.model.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerImpl implements OwnerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Owner insertOwner(Owner owner) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(owner);

        User user = new User();
        user.setEmail(owner.getUser().getEmail());
        user.setRole(owner.getUser().getRole());
        user.setEnabled(owner.getUser().isEnabled());
        user.setPassword(owner.getUser().getPassword());
        user.setOwner(owner);
        session.persist(user);

        return owner;
    }

    @Override
    public void deleteOwnerById(Long ownerId) {
        Session session = sessionFactory.getCurrentSession();
        Owner owner = session.get(Owner.class, ownerId);
        session.delete(owner);
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Owner.class, ownerId);
    }

    @Override
    public List<Owner> getOwnersByName(String firstName, String middleName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Owner> query = session.createQuery("from Owner where firstName=:ownerName and middleName=:middleName");
        query.setParameter("ownerName", firstName);
        query.setParameter("middleName", middleName);
        return query.list();
    }

    @Override
    public Owner getOwnerByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Owner> query = session.createQuery("SELECT o FROM Owner o JOIN o.user u WHERE u.email = :email", Owner.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    public Owner updateOwner(Owner newOwner) {
        Session session = sessionFactory.getCurrentSession();
        Owner oldOwner = session.get(Owner.class, newOwner.getId());
        User oldUser = oldOwner.getUser();
        User newUser = newOwner.getUser();

        // Update user fields
        oldUser.setPassword(newUser.getPassword());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setRole(newUser.getRole());
        oldUser.setEnabled(newUser.isEnabled());
        oldUser.setOwner(newOwner);

        // Update owner fields
        oldOwner.setAddress(newOwner.getAddress());
        oldOwner.setFirstName(newOwner.getFirstName());
        oldOwner.setLastName(newOwner.getLastName());
        oldOwner.setGender(newOwner.getGender());
        oldOwner.setDateOfBirth(newOwner.getDateOfBirth());
        oldOwner.setBloodType(newOwner.getBloodType());
        oldOwner.setUser(newUser);

        return oldOwner;
    }

    @Override
    public List<Owner> getAllOwners() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Owner ");
        return(List<Owner>) query.list();
    }
}
