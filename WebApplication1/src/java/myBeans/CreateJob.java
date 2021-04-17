/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import enterpriseBeans.newJobBeanLocal;
//import enterpriseBeans.updateJobBeanLocal;
import BackEnd.Jobs;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Reiner
 */
@Named(value = "createJobBean")
@RequestScoped
public class CreateJob {

    @EJB
    private newJobBeanLocal newJobBean;

    private int JD_ID;
    private int PID;
    private String title;
    private String description;
    private String keywords;
    private double payment;
    
    

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Integer getJD_ID() {
        return JD_ID;
    }

    public void setJD_ID(Integer JD_ID) {
        this.JD_ID = JD_ID;
    }
    
    public Integer getPID() {
        return PID;
    }

    public void setPID(Integer PID) {
        this.PID = PID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String Keywords) {
        this.keywords = Keywords;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }


    /**
     * Creates a new customer with name, city, state stored in this bean
     */
    public void create() {
        JD_ID = newJobBean.createNewJob(PID, title, description,
             keywords, payment);
    }

    /**
     * Creates a new instance of AddCustomerBean
     */
    public CreateJob() {
        JD_ID = 0;
    }
    
    public String notification() {
        if (JD_ID == 0) return "";
        else return "New user with id " + JD_ID + " created!!!";
    }

}