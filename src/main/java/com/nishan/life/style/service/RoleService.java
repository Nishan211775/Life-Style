/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.service;

import com.nishan.life.style.dao.imp.RoleDaoImp;
import java.util.List;
import javax.management.relation.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "roleService")
public class RoleService implements GenericService<Role>{

    @Autowired
    RoleDaoImp rdi;
    
    @Override
    public void insert(Role t) {
        rdi.insert(t);
    }

    @Override
    public void update(Role t) {
        rdi.update(t);
    }

    @Override
    public boolean delete(int id) {
        return rdi.delete(id);
    }

    @Override
    public List<Role> getAll() {
        return rdi.getAll();
    }

    @Override
    public Role getById(int id) {
        return rdi.getById(id);
    }
}
