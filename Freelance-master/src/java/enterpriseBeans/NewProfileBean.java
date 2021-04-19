/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Profile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

/**
 *
 * @author Reiner
 */
@Stateless
public class NewProfileBean implements NewProfileBeanLocal {

    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;

    /**
     * Adds a new customer to the database with given name and city. Note:
     * Required foreign keys DiscountCode and MicroMarket for the table Profile
     * are fixed in this example.
     *
     * @param flance freelance tag
     * @param prov provider tag
     * @param adm admin tag
     * @param name New name for new customer
     * @param email Email for new customer
     * @param skills Skills for new customer
     * @param description description tag
     * @param balance account balance
     * @param password password for account
     * @return ID of newly created customer
     */
    public int createProfile(boolean flance, boolean prov, boolean adm,
             String name, String email, String skills, String description,
             double balance, String password) {
        Integer uid = (Integer) em.createNamedQuery("Profile.getHighestProfileID").getSingleResult();
        // id is current highest, increment to next id
        if (uid == null){
            uid=0;
        }
        
        uid++;
        // create customer object
        Profile p = new Profile(uid);

        // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(p);
        // set city and name and state
        p.setFlance(flance);
        p.setProv(prov);
        p.setAdm(adm);
        p.setName(name);
        p.setEmail(email);
        p.setSkills(skills);
        p.setDescription(description);
        p.setBalance(balance);
        p.setPassword(password);
        // return id of new customer
        return uid;

    }

    /**
     * make the passed object persistent
     *
     * @param object object to be made persistent
     */
    public void persist(Object object) {
        em.persist(object);
    }
}
