/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.dao;

import com.nishan.life.style.entity.Profile;
import java.util.List;

/**
 *
 * @author Nishan Dhungana
 */
public interface ProfileDAO extends GenericDAO<Profile> {
    public Profile getByUsername(String username);
}
