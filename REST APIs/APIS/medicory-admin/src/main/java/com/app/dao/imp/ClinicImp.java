package com.app.dao.imp;

import com.app.dao.ClinicDao;
import com.app.model.Clinic;
import com.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ClinicImp implements ClinicDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Clinic insertClinic(Clinic clinic) {
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setEmail(clinic.getUser().getEmail());
        user.setPassword(clinic.getUser().getPassword());
        user.setRole(clinic.getUser().getRole());
        user.setEnabled(clinic.getUser().isEnabled());
        user.setClinic(clinic);
        clinic.setUser(user);

        session.persist(user);

        return clinic;
    }

    @Override
    @Transactional
    public Clinic updateClinic(Clinic newClinic) {
       Session session = sessionFactory.getCurrentSession();
       Clinic oldClinic = session.get(Clinic.class, newClinic.getId());
        // Update user details
        User oldUser = oldClinic.getUser();
        if (oldUser != null) {
            oldUser.setEmail(newClinic.getUser().getEmail());
            oldUser.setPassword(newClinic.getUser().getPassword());
            oldUser.setRole(newClinic.getUser().getRole());
            oldUser.setEnabled(newClinic.getUser().isEnabled());
            session.update(oldUser);
        }
        oldClinic.setAddress(newClinic.getAddress());
        oldClinic.setSpecialization(newClinic.getSpecialization());
        oldClinic.setName(newClinic.getName());
        oldClinic.setOwnerName(newClinic.getOwnerName());
        oldClinic.setGoogleMapsLink(newClinic.getGoogleMapsLink());
        session.update(oldClinic);
        return oldClinic;
    }

    @Override
    @Transactional
    public List<Clinic> getAllClinics() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Clinic ");
        return (List<Clinic>) query.list();
    }

    @Override
    @Transactional
    public Clinic getClinicById(Long id) {
        Session session=sessionFactory.getCurrentSession();
        Clinic clinic =session.get(Clinic.class,id);
        return clinic;
    }

    @Override
    @Transactional
    public List<Clinic> getClinicsBName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Clinic> query = session.createQuery("FROM Clinic c WHERE c.name = :name", Clinic.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Clinic getClinicByEmail(String email) {
        Session session =sessionFactory.getCurrentSession();
        Query<Clinic> query = session.createQuery("FROM Clinic c WHERE c.user.email = :email", Clinic.class);
        query.setParameter("email", email);
           return query.uniqueResult();
    }

    @Override
    @Transactional
    public void deleteClinicById(Long id) {
        Session session = sessionFactory.getCurrentSession();
       Clinic clinic = session.get(Clinic.class, id);
        User user= session.get(User.class,clinic.getUser().getId());
        session.delete(user);
    }
}
