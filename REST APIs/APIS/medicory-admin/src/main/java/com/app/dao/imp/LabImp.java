package com.app.dao.imp;

import com.app.dao.LabDao;
import com.app.model.Clinic;
import com.app.model.Lab;
import com.app.model.Owner;
import com.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class LabImp implements LabDao {
     @Autowired
      SessionFactory sessionFactory;
    @Override
    public Lab insertLab(Lab lab) {
        Session session= sessionFactory.getCurrentSession();
        User user = new User();
        user.setEmail(lab.getUser().getEmail());
        user.setRole(lab.getUser().getRole());
        user.setEnabled(lab.getUser().isEnabled());
        user.setPassword(lab.getUser().getPassword());
        user.setLab(lab);
        lab.setUser(user);
        session.persist(user);
        return lab;
    }

    @Override
    public Lab updateLab(Lab newLab) {
        Session session = sessionFactory.getCurrentSession();
     Lab oldLab = session.get(Lab.class, newLab.getId());
     User olduser= oldLab.getUser();
     User  newUser =newLab.getUser();
     if(olduser!=null){
         olduser.setPassword(newUser.getPassword());
         olduser.setEmail(newUser.getEmail());
         olduser.setEnabled(newUser.isEnabled());
         olduser.setRole(newUser.getRole());
           session.update(olduser);
     }
     oldLab.setAddress(newLab.getAddress());
     oldLab.setName(newLab.getName());
     oldLab.setOwnerName(newLab.getOwnerName());
     oldLab.setGoogleMapsLink(newLab.getGoogleMapsLink());
     oldLab.setUser(olduser);
     session.update(oldLab);
     return oldLab;
    }

    @Override
    public List<Lab> getAllLabs() {
      Session session = sessionFactory.getCurrentSession();
        Query query =session.createQuery("FROM Lab ");
        return (List<Lab>) query.list();
    }

    @Override
    public Lab getLabById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Lab lab = session.get(Lab.class,id);
        return lab;
    }

    @Override
    @Transactional

    public Lab getLabByEmail(String email) {
      Session session= sessionFactory.getCurrentSession();
        System.out.println(email);
        Query<Lab> query = session.createQuery("SELECT o FROM Lab o JOIN FETCH o.user u WHERE u.email = :email", Lab.class);
        query.setParameter("email", email);
        System.out.println(query.uniqueResult());
        return query.uniqueResult();
    }

    @Override
    public List<Lab> getLabsByName(String labName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Lab> query = session.createQuery("FROM Lab l WHERE l.name = :name", Lab.class);
        query.setParameter("name", labName);
        return query.getResultList();
    }

    @Override
    public void deleteLabById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Lab lab = session.get(Lab.class,id);
        User user = lab.getUser();
        session.delete(user);
    }
}
