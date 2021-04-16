/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Fiachra
 */

@Entity
@Table(name = "JOBS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.getHighestJD_ID", query = "SELECT MAX(j.JD_ID) from Job j")})

public class Job implements Serializable{
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JD_ID")
    private Integer JD_ID;

    @Column(name = "PID")
    private Integer PID;
    @Column(name = "FID")
    private int FID;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String Description;
    @Size(max = 50)
    @Column(name = "KEYWORDS")
    private String Keywords;
    @Column(name = "PAYMENT")
    private Double Payment;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String Status;
    @Size(max = 50)
    @Column(name = "CREATED_ON")
    private LocalDate CreatedOn;
    

    public Job(int JD_ID,String title,String Description,String Keywords,
            String Status,double Payment,LocalDate CreatedOn){
        
        this.JD_ID=JD_ID;
        this.title=title;
        this.Description=Description;
        this.Keywords=Keywords;
        this.Status=Status;
        this.Payment=Payment;
        this.CreatedOn=CreatedOn;
    }
    
    public Job(int JD_ID){
        this.JD_ID=JD_ID;
    }
    
    public int getJD_ID() {
        return JD_ID;
    }

    public void setJD_ID(int JD_ID) {
        this.JD_ID = JD_ID;
    }
    
    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    } 
    
    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String Keywords) {
        this.Keywords = Keywords;
    }
    
        
    public double getPayment() {
        return Payment;
    }

    public void setPayment(double Payment) {
        this.Payment = Payment;
    }
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    /**
     * Get the value of CreatedOn
     *
     * @return the value of CreatedOn
     */
    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    /**
     * Set the value of CreatedOn
     *
     * @param CreatedOn new value of CreatedOn
     */
    public void setCreatedOn(LocalDate CreatedOn) {
        this.CreatedOn = CreatedOn;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (JD_ID != null ? JD_ID.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.JD_ID == null && other.JD_ID != null) || (this.JD_ID != null && !this.JD_ID.equals(other.JD_ID))) {
            return false;
        }
        return true;
    }
    /**
     * Creates a new instance of Job
     */
    public Job() {
    }
}
