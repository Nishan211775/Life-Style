/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.dao.imp;

import com.nishan.life.style.dao.RoleDao;
import javax.management.relation.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "roleDaoImp")
public class RoleDaoImp extends GenericDAOImp<Role> implements RoleDao{
    
}
