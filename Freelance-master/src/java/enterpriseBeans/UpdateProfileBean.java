/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Reiner
 */
@Stateless
public class UpdateProfileBean implements UpdateProfileBeanLocal {

    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;

    /**
     * updates an existing profile
     * 
     * @param id ID of profile to be updated
     * @param name new name for profile
     * @param loggedin new loggedin for profile
     * @param password new password for profile
     */
    @Override
    public void update(int id, String name, boolean loggedin, String password) {
        Profile custom = getProfile(id);
        if (custom != null) {
            custom.setName(name);
            custom.setLoggedin(loggedin);
            custom.setPassword(password);
        }
    }
    
    @Override
    public void Loggedin(Profile profile) {
        int id = profile.getUid();
        Profile custom = getProfile(id);
        if (custom != null) {
            custom.setLoggedin(true);
        }
    }
    
    @Override
    public void Loggedout() {
        Query query = em.createNamedQuery("Profile.findByLoggedin")
                                .setParameter("loggedin", true);
        Profile custom = (Profile) query.getSingleResult();
        if (custom != null) {
            custom.setLoggedin(false);
        }
    }

    /**
     * Returns an entity object of profile with given id
     * 
     * @param uid ID of profile to be returned
     * @return Profile object with id 
     */
    @Override
    public Profile getProfile(int uid) {
        // create named query and set parameter
        Query query = em.createNamedQuery("Profile.findByUid")
                .setParameter("uid", uid);
        List<Profile> result = query.getResultList();
        return result.get(0);
    }
    
    /**
     * make the passed object persistent
     * @param object object to be made persistent
     */
    public void persist(Object object) {
        em.persist(object);
    }

}
