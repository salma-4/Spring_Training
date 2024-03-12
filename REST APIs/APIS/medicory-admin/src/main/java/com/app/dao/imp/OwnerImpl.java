package com.app.dao.imp;

import com.app.dao.OwnerDao;
import com.app.model.Owner;
import com.app.model.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OwnerImpl implements OwnerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Owner insertOwner(Owner owner) {
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setEmail(owner.getUser().getEmail());
        user.setPassword(owner.getUser().getPassword());
        user.setRole(owner.getUser().getRole());
        user.setEnabled(owner.getUser().isEnabled());
        user.setOwner(owner);

        owner.setUser(user);

        session.persist(user);

        return owner;
    }

    @Override
    public void deleteOwnerById(Long ownerId) {
        Session session = sessionFactory.getCurrentSession();
        Owner owner = session.get(Owner.class, ownerId);
        User user= session.get(User.class,owner.getUser().getId());
        session.delete(user);
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        Session session = sessionFactory.getCurrentSession();
        Owner owner = session.get(Owner.class, ownerId);
        return owner;
    }

    @Override
    public List<Owner> getOwnersByName(String firstName, String middleName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Owner> query = session.createQuery("select o from Owner o join fetch o.user u " +
                        "where o.firstName = :ownerName and o.middleName = :middleName", Owner.class);
        query.setParameter("ownerName", firstName);
        query.setParameter("middleName", middleName);
        return query.getResultList();
    }

    @Override
    public Owner getOwnerByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<Owner> query = session.createQuery("SELECT o FROM Owner o JOIN FETCH o.user u WHERE u.email = :email", Owner.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    @Transactional
    public Owner updateOwner(Owner newOwner) {
        try {
            Session session = sessionFactory.getCurrentSession();

            Owner oldOwner = session.get(Owner.class, newOwner.getId());
            // Update user details
            User oldUser = oldOwner.getUser();
            if (oldUser != null) {
                oldUser.setEmail(newOwner.getUser().getEmail());
                oldUser.setPassword(newOwner.getUser().getPassword());
                oldUser.setRole(newOwner.getUser().getRole());
                oldUser.setEnabled(newOwner.getUser().isEnabled());
                session.update(oldUser);
            }

            // Update owner details
            oldOwner.setGender(newOwner.getGender());
            oldOwner.setDateOfBirth(newOwner.getDateOfBirth());
            oldOwner.setAddress(newOwner.getAddress());
            oldOwner.setLastName(newOwner.getLastName());
            oldOwner.setBloodType(newOwner.getBloodType());
            oldOwner.setFirstName(newOwner.getFirstName());
            oldOwner.setMiddleName(newOwner.getMiddleName());
            session.update(oldOwner);

            return oldOwner;
        } catch (Exception ex) {
            // Handle exceptions
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Owner> getAllOwners() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Owner ");

        return(List<Owner>) query.list();
    }
}
