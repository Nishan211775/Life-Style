/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.service;
import com.nishan.life.style.dao.imp.ProfileDaoImp;
import com.nishan.life.style.entity.Profile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "profileService")
public class ProfileService implements GenericService<Profile>{
    
    @Autowired
    private ProfileDaoImp profileDaoImp;

    @Override
    public void insert(Profile t) {
        profileDaoImp.insert(t);
    }

    @Override
    public void update(Profile t) {
        profileDaoImp.update(t);
    }

    @Override
    public boolean delete(int id) {
        return profileDaoImp.delete(id);
    }

    @Override
    public List<Profile> getAll() {
        return profileDaoImp.getAll();
    }

    @Override
    public Profile getById(int id) {
        return profileDaoImp.getById(id);
    }
    
    public Profile getByUsername(String username) {
        return profileDaoImp.getByUsername(username);
    }
    
}
