/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.api;

import com.nishan.life.style.entity.Profile;
import com.nishan.life.style.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/api/profile")
public class ProfileController {
    
    @Autowired
    private ProfileService pdi;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Profile>> getAll() {
        
        List<Profile> res = pdi.getAll();
        
        if (res != null) {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
