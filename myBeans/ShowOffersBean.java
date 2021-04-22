
package myBeans;

import entities.Jobs;
import entities.Offers;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fiachra
 */
@Named(value = "showOffersBean")
@RequestScoped
public class ShowOffersBean {
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    @ManagedProperty("#{param.param}")
    private Integer Param;
    Jobs job = new Jobs();
    Offers offer = new Offers();
    
    public Integer getParam() {
        return Param;
    }

    public void setParam(Integer Param) {
        this.Param = Param;
    }
    
    
    
    
    /**
     * Creates a new instance of showJobBean
     */
    public ShowOffersBean() {
    }

    /**
     * Returns list of customer with a given name
     * 
     * @return All customer with name customerName
     */
    public List<Offers> getAllOffers() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Offers.findAll");
        // return query result
        return query.getResultList();
    }
    
    public List<Offers> getOffersJdId() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Offers.findByJID").setParameter("JID", Param);
        // return query result
        return query.getResultList();
    }
  
    
    
    public void removeOffer(Offers Offer){
 
        remove(Offer);
    }
    
    public void acceptOffer(){
            
        offer.setOfferStatus("Accepted");
        job.setStatus("Closed");
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
        
    /**
     * Auto-generated method for managing access to persist method
     * of entity manager
     * 
     * @param object Object to be made persistent
     */
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

    private void newList(List<Offers> QueryList1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



