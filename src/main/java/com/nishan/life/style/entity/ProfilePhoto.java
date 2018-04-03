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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_PROFILE_PHOTO", catalog = "", schema = "NISHANDH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfilePhoto.findAll", query = "SELECT p FROM ProfilePhoto p")
    , @NamedQuery(name = "ProfilePhoto.findByPhotoId", query = "SELECT p FROM ProfilePhoto p WHERE p.photoId = :photoId")
    , @NamedQuery(name = "ProfilePhoto.findByPhotoPath", query = "SELECT p FROM ProfilePhoto p WHERE p.photoPath = :photoPath")
    , @NamedQuery(name = "ProfilePhoto.findByPhotoName", query = "SELECT p FROM ProfilePhoto p WHERE p.photoName = :photoName")
    , @NamedQuery(name = "ProfilePhoto.findByAddedDate", query = "SELECT p FROM ProfilePhoto p WHERE p.addedDate = :addedDate")
    , @NamedQuery(name = "ProfilePhoto.findByActive", query = "SELECT p FROM ProfilePhoto p WHERE p.active = :active")})
public class ProfilePhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @NotNull
    @Column(name = "PHOTO_ID")
    private int photoId;
    
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "PHOTO_PATH")
    private String photoPath;
    
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "PHOTO_NAME")
    private String photoName;
    
    @NotNull
    @Column(name = "ADDED_DATE", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    
    @NotNull
    @Column(name = "ACTIVE", insertable = false)
    private boolean active;
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "PROFILE_ID")
    @ManyToOne(optional = false)
    private Profile profileId;

    public ProfilePhoto() {
    }

    public ProfilePhoto(int photoId) {
        this.photoId = photoId;
    }

    public ProfilePhoto(int photoId, String photoPath, String photoName, Date addedDate, boolean active) {
        this.photoId = photoId;
        this.photoPath = photoPath;
        this.photoName = photoName;
        this.addedDate = addedDate;
        this.active = active;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Profile getProfileId() {
        return profileId;
    }

    public void setProfileId(Profile profileId) {
        this.profileId = profileId;
    }

}
