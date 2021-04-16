/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;


import java.time.LocalDate;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped; 
import javax.inject.Named;
import enterpriseBeans.newJobBeanLocal;

/**
 *
 * @author Fiachra
 */

@Named(value = "createJob")
@RequestScoped
public class CreateJob{
 
    @EJB
    private newJobBeanLocal newJobBean;
    
    private int JD_ID;
    private int PID;
    private String title;
    private String description;
    private String keywords;
    private double payment;
    private String status;
    private LocalDate createdOn;
    
    
    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
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
    
    public String getStatus() {
        return status;
    }

    public void setStauts(String Status) {
        this.status = Status;
    }
    
    public double getPayment() {
        return payment;
    }

    public void setPayment(double Payment) {
        this.payment = Payment;
    }
    
    /**
     * Get the value of CreatedOn
     *
     * @return the value of CreatedOn
     */
    public LocalDate getCreatedOn() {
        return createdOn;
    }

    /**
     * Set the value of CreatedOn
     *
     * @param CreatedOn new value of CreatedOn
     */
    public void setCreatedOn(LocalDate CreatedOn) {
        this.createdOn = CreatedOn;
    }
    
    public void create(){
        JD_ID = newJobBean.createNewJob(PID, title, 
                description, keywords, payment);
    }
    
    public void CreateJob(){
        JD_ID = 0;
    }
    
    public String notification() {
        if (JD_ID == 0) return "";
        else return "New job with id " + JD_ID + " created!!!";
    }
}
