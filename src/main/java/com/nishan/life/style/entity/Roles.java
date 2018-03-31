/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_ROLES", catalog = "", schema = "NISHANDH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByRolesId", query = "SELECT r FROM Roles r WHERE r.rolesId = :rolesId")
    , @NamedQuery(name = "Roles.findByProfileRole", query = "SELECT r FROM Roles r WHERE r.profileRole = :profileRole")
    , @NamedQuery(name = "Roles.findByUsername", query = "SELECT r FROM Roles r WHERE r.username = :username")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @NotNull
    @Column(name = "ROLES_ID")
    private int rolesId;
    
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PROFILE_ROLE", insertable = false)
    private String profileRole;
    @Size(max = 100)
    @Column(name = "USERNAME")
    private String username;

    public Roles() {
    }

    public Roles(int rolesId) {
        this.rolesId = rolesId;
    }

    public Roles(int rolesId, String profileRole) {
        this.rolesId = rolesId;
        this.profileRole = profileRole;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    public String getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(String profileRole) {
        this.profileRole = profileRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
