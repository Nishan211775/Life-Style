/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.dao.imp;

import com.nishan.life.style.dao.ProfileDAO;
import com.nishan.life.style.daoImp.GenericDAOImp;
import com.nishan.life.style.entity.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nishan Dhungana
 */
@Repository(value = "profileDaoImp")
public class ProfileDaoImp extends GenericDAOImp<Profile> implements ProfileDAO{
    
}
