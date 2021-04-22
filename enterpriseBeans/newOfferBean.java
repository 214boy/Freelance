/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;


import entities.Offers;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class newOfferBean implements newOfferBeanLocal{
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
   
    
    
    @Override
    public int createNewOffer(Integer JID){

        Integer id = (Integer) em.createNamedQuery("Offers.getHighestOfferID").getSingleResult();
        
        if(id == null){
            id=0;
        }
        //named query to the current user table
        //int pid = (Integer) em.createNamedQuery("Jobs.getHighestJobID").getSingleResult();
        
        // id is current highest, increment to next id
        id++;
        
        

        // create customer object
        Offers o = new Offers(id);


  
         // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(o);

        
       


        o.setJID(JID);
        o.setOfferStatus("Offered");
        
        
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