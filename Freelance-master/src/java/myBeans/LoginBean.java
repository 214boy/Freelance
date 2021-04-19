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
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private String profileName;
    private String profilePassword;
    
    /**
     * Creates a new instance of ShowProfileBean
     */
    public LoginBean() {
    }

    /**
     * Returns list of profile with a given name
     * 
     * @return All profile with name profileName
     */
    public int getProfileType() {
        // create named query and set parameter
        Profile query =(Profile) em.createNamedQuery(
                "Profile.findByName")
                .setParameter("name", profileName);
        if(query.getFlance()){
            return 1;
        }
        else if (query.getProv()){
            return 2;
        }
        else if (query.getAdm()){
            return 3;
        }
        else return 0;
    }
    
    /**
     * Returns list of profile with a given name
     * 
     * @return All profile with name profileName
     */
    public boolean getNameMatch() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Profile.findByName")
                .setParameter("name", profileName);
        // return query result
        return !query.getResultList().isEmpty();
    }

    /**
     * Returns a list of profile from a given email
     * 
     * @return List of profiles in a email
     */
    public boolean isPasswordMatch() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByPassword")
                .setParameter("password", profilePassword);
        // return query result
        return !query.getResultList().isEmpty();
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
     * Getter for profilePassword
     * @return value of profilePassword
     */
    public String getProfilePassword() {
        return profilePassword;
    }

    /**
     * Setter for profilePassword
     * @param profilePassword new value for profilePassword
     */
    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
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
