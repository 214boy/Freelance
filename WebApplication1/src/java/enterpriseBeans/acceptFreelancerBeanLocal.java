/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import BackEnd.Jobs;
import javax.ejb.Local;
/**
 *
 * @author lunch
 */
@Local
public interface acceptFreelancerBeanLocal {
    public void acceptFreelancer(int JD_ID, int FID, String Freelancer);
    public Jobs getJob(int JD_ID);
    public void jobCompleted(int JD_ID);
}

