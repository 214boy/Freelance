/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import enterpriseBeans.newOfferBeanLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Reiner
 */
@Named(value = "newOfferBean")
@RequestScoped
public class CreateOffer {

    @EJB
    private newOfferBeanLocal newOfferBean;
    
    private int freelancer_ID;
    private String description;
    private Integer JID;
    
    

    /**
     * Get the value of id
     *
     * @return the value of id
     */

    public Integer getfreelancer_ID() {
        return freelancer_ID;
    }

    public void setfreelancer_ID(Integer freelancer_ID) {
        this.freelancer_ID = freelancer_ID;
    }
    
    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getJID() {
        return JID;
    }

    public void setJID(Integer JID) {
        this.JID = JID;
    }   
    
    
    public void create() {
        freelancer_ID = newOfferBean.createNewOffer(JID);
    }
    
    public CreateOffer() {
        freelancer_ID = 0;
    }
    
    public String notification() {
        if (freelancer_ID == 0) return "";
        else return "New user with id " + freelancer_ID + " created!!!";
    }

}
