/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import BackEnd.Jobs;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lunch
 */

@Stateless
public class newJobBean implements newJobBeanLocal{
    
    @PersistenceContext(unitName = "PersistanceUnit")
    private EntityManager em;
         
    
    /**
     * Adds a new customer to the database with given name and city. Note:
     * Required foreign keys DiscountCode and MicroMarket for the table Customer
     * are fixed in this example.
     *
     * @param PID
     * @param title
     * @param Description
     * @param Keywords
     * @param payment
     * @return ID of newly created job
     */

    public int createNewJob(int PID, String title, String Description, 
    String Keywords,double payment){
        
        Date CreatedOn = new Date();
        int id = (Integer) em.createNamedQuery("Jobs.getHighestJobID").getSingleResult();
        // id is current highest, increment to next id
        id++;
        // create customer object
        Jobs j = new Jobs(id);


  
         // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(j);

        
       
        j.setPid(PID);
        j.setTitle(title);
        j.setDescription(Description);
        j.setKeywords(Keywords);
        j.setStatus("Open");
        j.setPayment(payment);
        j.setCreatedon(CreatedOn);
        

        // return id of new customer
        return id;

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
