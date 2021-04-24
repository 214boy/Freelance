/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBeans;

import entities.Profile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author reiner.dojen
 */
@Named(value = "showProfileBean")
@RequestScoped
public class ShowProfileBean {
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private String profileName;
    private String profileEmail;
    private boolean profileFlance; 
    private boolean profileProv;
    private boolean profileLoggedin; 
    
    /**
     * Creates a new instance of ShowProfileBean
     */
    public ShowProfileBean() {
    }
    
    public List<Profile> getAllProfiles() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Profile.findAll");
        // return query result
        return query.getResultList();
    }

    /**
     * Returns list of profile with a given name
     * 
     * @return All profile with name profileName
     */
    public List<Profile> getProfileByName() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Profile.findByName")
                .setParameter("name", profileName);
        // return query result
        return query.getResultList();
    }

    /**
     * Returns a list of profile from a given email
     * 
     * @return List of profiles in a email
     */
    public List<Profile> getProfileByEmail() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByEmail")
                .setParameter("email", profileEmail);
        // return query result
        return query.getResultList();
    }
    
    /**
     * Returns a list of profile from a given email
     * 
     * @return List of profiles in a email
     */
    public List<Profile> getProfileByFlance() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByFlance")
                .setParameter("flance", profileFlance);
        // return query result
        return query.getResultList();
    }
    
    public List<Profile> getProfileByProv() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByProv")
                .setParameter("prov", profileProv);
        // return query result
        return query.getResultList();
    }
    
    public List<Profile> getProfileByLoggedin() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByLoggedin")
                .setParameter("loggedin", profileLoggedin);
        // return query result
        return query.getResultList();
    }

    
    /**
     * Getter for profileName
     * @return value of profileName 
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * Setter for profileName
     * @param profileName new value for profileName
     */
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    /**
     * Getter for profileEmail
     * @return value of profileEmail
     */
    public String getProfileEmail() {
        return profileEmail;
    }

    /**
     * Setter for profileEmail
     * @param profileEmail new value for profileEmail
     */
    public void setProfileEmail(String profileEmail) {
        this.profileEmail = profileEmail;
    }
    
    /**
     * Getter for profileFlance
     * @return value of profileFlance
     */
    public boolean isProfileFlance() {
        return profileFlance;
    }

    /**
     * Setter for profileFlance
     * @param profileFlance new value for profileEmail
     */
    public void setProfileFlance(boolean profileFlance) {
        this.profileFlance = profileFlance;
    }
    
    /**
     * Getter for profileFlance
     * @return value of profileProv
     */
    public boolean isProfileProv() {
        return profileProv;
    }

    /**
     * Setter for profileFlance
     * @param profileProv new value for profileProv
     */
    public void setProfileProv(boolean profileProv) {
        this.profileProv = profileProv;
    }

    public void remove(Object object) {
        try {
            utx.begin();
            if (!em.contains(object)) {
            object = em.merge(object);
            }
            em.remove(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Auto-generated method for managing access to persist method
     * of entity manager
     * 
     * @param object Object to be made persistent
     */
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    
}
