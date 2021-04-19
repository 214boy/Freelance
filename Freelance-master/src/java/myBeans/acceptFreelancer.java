package myBeans;

import entities.Jobs;
import enterpriseBeans.acceptFreelancerBeanLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author fiachra
 */

@Named(value = "acceptFreelancer")
@SessionScoped
public class acceptFreelancer implements Serializable {
     
    @EJB
    private acceptFreelancerBeanLocal acceptFreelancerBean;
    
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    private int id;
    private int fid;
    private String freelancer;
    private Jobs job;


    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id Also populates the custom field with the matching
     * Entity object from entity manager and updates fields name, city, state to
     * match entity object.
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
        job = acceptFreelancerBean.getJob(id);  
        if (job!= null){
            fid=job.getFid();
        }
    }
    
    public int getFid() {
        return fid;
    }

    /**
     * Set the value of id Also populates the custom field with the matching
     * Entity object from entity manager and updates fields name, city, state to
     * match entity object.
     *
     * @param id new value of id
     */
    public void setFid(int fid) {
        this.fid = fid;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getFreelancer() {
        return freelancer;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setFreelancer(String freelancer) {
        this.freelancer = freelancer;
    }

    
    /**
     * Creates a new instance of EditCustomerBean
     */
    public acceptFreelancer() {
        id = 1; // ensure id has a valid value
    }

    public Jobs getJobs(){
        return job;
    }
    
    public void setJobs(Jobs job){
        this.job=job;
    }
    
    
    public void acceptJob() {
        acceptFreelancerBean.acceptFreelancer(id, fid, freelancer);
    }
    
    public void JobCompleted(){
       acceptFreelancerBean.jobCompleted(id);
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