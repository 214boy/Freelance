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
     * @param email new email for profile
     * @param password new password for profile
     */
    @Override
    public void update(int id, String name, String email, String password) {
        Profile custom = getProfile(id);
        if (custom != null) {
            custom.setName(name);
            custom.setEmail(email);
            custom.setPassword(password);
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
        Query query = em.createNamedQuery("Profile.findByProfileId")
                .setParameter("uid", uid);
        List<Profile> result = query.getResultList();
        return result.get(0);
    }
    
    public String deleteAction(Profile p) {
                em.remove(p);
        return null;
    }

    /**
     * make the passed object persistent
     * @param object object to be made persistent
     */
    public void persist(Object object) {
        em.persist(object);
    }

}
