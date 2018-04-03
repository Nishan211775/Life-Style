/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.controller;

import com.nishan.life.style.entity.Login;
import com.nishan.life.style.entity.Profile;
import com.nishan.life.style.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nishan Dhungana
 */
@Controller
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:8100")

public class AuthorizationController {
    
    @Autowired
    private ProfileService ps;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET) 
    public ResponseEntity<Profile> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Login login = new Login(username, password);
        Profile profile = ps.login(login);
        
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public ResponseEntity<Void> createAccount(@RequestBody Profile profile) {
        
        try {
            ps.insert(profile);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
