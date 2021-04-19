
package myBeans;

import BackEnd.Jobs;
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
 * @author fiachra
 */
@Named(value = "showJobsBean")
@RequestScoped
public class showJobsBean {
    @PersistenceContext(unitName = "PersistanceUnit")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    /**
     * Creates a new instance of showJobBean
     */
    public showJobsBean() {
    }

    /**
     * Returns list of customer with a given name
     * 
     * @return All customer with name customerName
     */
    public List<Jobs> getAllJobs() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Jobs.findAll");
        // return query result
        return query.getResultList();
    }
     
    
    
    public void removeJob(Jobs Job){
 
        remove(Job);
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
}



