/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.dao.imp;

import com.nishan.life.style.dao.ProfileDAO;
import com.nishan.life.style.entity.Login;
import com.nishan.life.style.entity.Profile;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "profileDaoImp")
public class ProfileDaoImp extends GenericDAOImp<Profile> implements ProfileDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session session;
    private Transaction trans;
    
    @Override
    public Profile getByUsername(String username) {
        session = sessionFactory.openSession();
        //trans = session.beginTransaction();
        
        final String hql = "SELECT p FROM Profile p WHERE p.username =:usernameParam";
        Profile p = null;
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("usernameParam", username);
            p = (Profile) query.uniqueResult();
        } catch(HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        
        return p;
    }

    @Override
    public Profile login(Login login) {
        session = sessionFactory.openSession();
        Profile profile = null;
        
        final String hql = "SELECT p FROM Profile p WHERE p.username=:usernameParam and p.password=:passParam";
        
        try {
            Query query = session.createQuery(hql);
            query.setParameter("usernameParam", login.getUsername());
            query.setParameter("passParam", login.getPassword());
            
            profile = (Profile)query.uniqueResult();
            
        } catch(HibernateException e) {
            
        } finally {
            session.close();
        }
        
        return profile;
    }
    
    
}
