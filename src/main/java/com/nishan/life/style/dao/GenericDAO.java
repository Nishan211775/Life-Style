/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.dao;

import java.util.List;

/**
 *
 * @author Nishan Dhungana
 * @param <T>
 */
public interface GenericDAO<T> {
    public void insert(T t);
    public void update(T t);
    public boolean delete(int id);
    public List<T> getAll();
    public T getById(int id);
}
