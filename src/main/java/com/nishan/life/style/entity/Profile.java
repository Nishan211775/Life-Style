 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishan.life.style.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nishan Dhungana
 */
@Entity
@Table(name = "TBL_PROFILE", catalog = "", schema = "NISHANDH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByProfileId", query = "SELECT p FROM Profile p WHERE p.profileId = :profileId")
    , @NamedQuery(name = "Profile.findByFullName", query = "SELECT p FROM Profile p WHERE p.fullName = :fullName")
    , @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email")
    , @NamedQuery(name = "Profile.findByAddress", query = "SELECT p FROM Profile p WHERE p.address = :address")
    , @NamedQuery(name = "Profile.findByContact", query = "SELECT p FROM Profile p WHERE p.contact = :contact")
    , @NamedQuery(name = "Profile.findByDob", query = "SELECT p FROM Profile p WHERE p.dob = :dob")
    , @NamedQuery(name = "Profile.findByUsername", query = "SELECT p FROM Profile p WHERE p.username = :username")
    , @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password")
    , @NamedQuery(name = "Profile.findByCreatedDate", query = "SELECT p FROM Profile p WHERE p.createdDate = :createdDate")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @NotNull
    @Column(name = "PROFILE_ID")
    private int profileId;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FULL_NAME")
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 100)
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USERNAME")
    private String username;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASS")
    private String password;
    
    @NotNull
    @Column(name = "CREATED_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull
    @Column(name = "ENABLED", insertable = false)
    private boolean enabled;
    
    public Profile() {
    }

    public Profile(int profileId) {
        this.profileId = profileId;
    }

    public Profile(int profileId, String fullName, String email, String username, String password, Date createdDate, boolean enabled) {
        this.profileId = profileId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.enabled = enabled;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}