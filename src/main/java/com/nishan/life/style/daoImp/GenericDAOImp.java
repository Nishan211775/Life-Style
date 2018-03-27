/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.daoImp;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public abstract class GenericDAOImp<T> implements com.nishan.life.style.dao.GenericDAO<T> {

    private final SessionFactory sessionFactory = null;
    private Transaction trans;
    private final Class<T> persistClass;
    
    public GenericDAOImp() {
        persistClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void insert(T t) {
        Session session = sessionFactory.openSession();
        trans = session.beginTransaction();

        try {
            session.save(t);
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        Session session = sessionFactory.openSession();
        trans = session.beginTransaction();

        try {
            session.update(t);
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        trans = session.beginTransaction();
        
        boolean res = false;
        
        T t = (T) session.get(persistClass, id);

        try {
            if (t != null) {
                session.delete(t);
                res = true;
            }
        } catch(HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }

        return res;
    }

    @Override
    public List<T> getAll() {
        Session session = sessionFactory.openSession();
        
        Criteria res = session.createCriteria(persistClass);
        return res.list();
    }

    @Override
    public T getById(int id) {
        Session session = sessionFactory.openSession();
        T t = (T) session.get(persistClass, id);
        return t;
    }

}
