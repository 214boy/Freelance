
package myBeans;

import BackEnd.Job;
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
    //@PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private String Jobs;
    private String customerCity;
    
    /**
     * Creates a new instance of ShowCustomerBean
     */
    public showJobsBean() {
    }

    /**
     * Returns list of customer with a given name
     * 
     * @return All customer with name customerName
     */
    public List<Job> getAllJobs() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Job.findAll");
        // return query result
        return query.getResultList();
    }

    /**
     * Returns a list of customer from a given city
     * 
     * @return List of customers in a city
     */
    public List<Job> getJobsByKeywords() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Jobs.findAll")
                .setParameter("city", customerCity);
        // return query result
        return query.getResultList();
    }
    
    /**
     * Getter for customerName
     * @return value of customerName 
     */
    public String getCustomerName() {
        return Jobs;
    }

    /**
     * Setter for customerName
     * @param customerName new value for customerName
     */
    public void setCustomerName(String customerName) {
        this.Jobs = customerName;
    }

    /**
     * Getter for customerCity
     * @return value of customerCity
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Setter for customerCity
     * @param customerCity new value for customerCity
     */
    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
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
    
