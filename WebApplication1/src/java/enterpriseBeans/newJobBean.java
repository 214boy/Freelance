/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import BackEnd.Job;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lunch
 */

@Stateless
public class newJobBean implements newJobBeanLocal{
    
    //@PersistenceContext(unitName = "PersistanceUnit")
    private EntityManager em;
         
    
    /**
     * Adds a new customer to the database with given name and city. Note:
     * Required foreign keys DiscountCode and MicroMarket for the table Customer
     * are fixed in this example.
     *
     * @param name New name for new customer
     * @param city City for new customer
     * @param state State for new customer
     * @return ID of newly created customer
     */

    @Override
    public int createNewJob(int PID, String title, String Description, 
    String Keywords,double payment){
        
        LocalDate CreatedOn = LocalDate.now();
        int id = (Integer) em.createNamedQuery("Job.getHighestJD_ID").getSingleResult();
        // id is current highest, increment to next id
        id++;
        // create customer object
        Job j = new Job(id);


  
         // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(j);

        
        // set city and name and state
        j.setPID(PID);
        j.setTitle(title);
        j.setDescription(Description);
        j.setStatus("Open");
        j.setPayment(payment);
        j.setCreatedOn(CreatedOn);
        

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
