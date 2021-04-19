/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import BackEnd.Jobs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lunch
 */
@Stateless
public class acceptFreelancerBean implements acceptFreelancerBeanLocal {
        
    @PersistenceContext(unitName = "PersistanceUnit")
    private EntityManager em;
    
    
    @Override
     public Jobs getJob(int JD_ID) {
        // create named query and set parameter
        Query query = em.createNamedQuery("Jobs.findByJdId")
                .setParameter("jdId", JD_ID);
        List<Jobs> result = query.getResultList();
        return result.get(0);
    }
     
    @Override
    public void acceptFreelancer(int JD_ID, int FID, String Freelancer){
              
        Jobs job = getJob(JD_ID);
        //need to get FID from offers
        if (job != null) {
            //job.setFid(FID);
            job.setStatus("Closed");
        }
    }
    
    
        
    @Override
    public void jobCompleted(int JD_ID){
              
        //move payment to freelancer
        
        Jobs job = getJob(JD_ID);
        if (job != null) {
            job.setStatus("Completed");
        }
    }
}
