/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.controller;

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
@RequestMapping(value = "/")
public class DefaultController {
    
    @Autowired
    ProfileService ps;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/getProfile", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Profile> getProfile() {
        Profile p = ps.getByUsername("nishandhungana41");
        
        if (p == null) {
            return new ResponseEntity<>(p, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Profile> getDetails() {
        Profile p = ps.getById(1);
        
        if (p == null) {
            return new ResponseEntity<>(p, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }
}
