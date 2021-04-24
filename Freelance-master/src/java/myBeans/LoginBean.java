/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBeans;

import enterpriseBeans.UpdateProfileBeanLocal;
import entities.Profile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.validator.ValidatorException;
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
    
    @EJB
    private UpdateProfileBeanLocal updateProfileBean;

    private String profileName;
    private String profilePassword;
    
    /**
     * Creates a new instance of ShowProfileBean
     */
    public LoginBean() {
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
     * @param return success of failure
     */
    
        public String validateUserLogin() {
        String navResult = "";
        Query query1 = em.createNamedQuery(
        "Profile.findByName")
            .setParameter("name", profileName);
        
        // return query result
        List <Profile> result1 = query1.getResultList();
        
        Profile type = (Profile) query1.getSingleResult();
        
        boolean free = type.getFlance();
        boolean provo = type.getProv();
        
        Query query2 = em.createNamedQuery(
        "Profile.findByPassword")
            .setParameter("password", profilePassword);
        
        // return query result
        List <Profile> result2 = query2.getResultList();
 

        if (result1.isEmpty() | result2.isEmpty()) {
             navResult = "failure";
        } else {
            if(free){
                navResult = "free";
                updateProfileBean.Loggedin(type);
                
            }
            else if (provo){
                navResult = "prov";
            }
            else {
                navResult = "admin";
            }
        }
            
        return navResult;
    }
    
    
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
