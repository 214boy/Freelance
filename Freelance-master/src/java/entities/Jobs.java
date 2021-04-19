/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lunch
 */
@Entity
@Table(name = "JOBS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j"),
    @NamedQuery(name = "Jobs.findByJdId", query = "SELECT j FROM Jobs j WHERE j.jdId = :jdId"),
    @NamedQuery(name = "Jobs.findByPid", query = "SELECT j FROM Jobs j WHERE j.pid = :pid"),
    @NamedQuery(name = "Jobs.findByFid", query = "SELECT j FROM Jobs j WHERE j.fid = :fid"),
    @NamedQuery(name = "Jobs.findByTitle", query = "SELECT j FROM Jobs j WHERE j.title = :title"),
    @NamedQuery(name = "Jobs.findByDescription", query = "SELECT j FROM Jobs j WHERE j.description = :description"),
    @NamedQuery(name = "Jobs.findByKeywords1", query = "SELECT j FROM Jobs j WHERE j.keywords1 = :keywords1"),
    @NamedQuery(name = "Jobs.findByKeywords2", query = "SELECT j FROM Jobs j WHERE j.keywords2 = :keywords2"),
    @NamedQuery(name = "Jobs.findByKeywords3", query = "SELECT j FROM Jobs j WHERE j.keywords3 = :keywords3"),
    @NamedQuery(name = "Jobs.findByPayment", query = "SELECT j FROM Jobs j WHERE j.payment = :payment"),
    @NamedQuery(name = "Jobs.findByStatus", query = "SELECT j FROM Jobs j WHERE j.status = :status"),
    @NamedQuery(name = "Jobs.getHighestJobID", query = "SELECT MAX(j.jdId) from Jobs j"),
    @NamedQuery(name = "Jobs.findByCreatedon", query = "SELECT j FROM Jobs j WHERE j.createdon = :createdon")})
public class Jobs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "JD_ID")
    private Integer jdId;
    @Column(name = "PID")
    private Integer pid;
    @Column(name = "FID")
    private Integer fid;
    @Size(max = 255)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "KEYWORDS1")
    private String keywords1;
    @Column(name = "KEYWORDS2")
    private String keywords2;    
    @Column(name = "KEYWORDS3")
    private String keywords3;
    @Column(name = "PAYMENT")
    private Double payment;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATEDON")
    @Temporal(TemporalType.DATE)
    private Date createdon;

    public Jobs() {
    }

    public Jobs(Integer jdId) {
        this.jdId = jdId;
    }

    public Integer getJdId() {
        return jdId;
    }

    public void setJdId(Integer jdId) {
        this.jdId = jdId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords1() {
        return keywords1;
    }

    public void setKeywords1(String keywords) {
        this.keywords1 = keywords;
    }
        
    public String getKeywords2() {
        return keywords2;
    }

    public void setKeywords2(String keywords) {
        this.keywords2 = keywords;
    }

    public String getKeywords3() {
        return keywords3;
    }

    public void setKeywords3(String keywords) {
        this.keywords3 = keywords;
    }
    
    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jdId != null ? jdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobs)) {
            return false;
        }
        Jobs other = (Jobs) object;
        if ((this.jdId == null && other.jdId != null) || (this.jdId != null && !this.jdId.equals(other.jdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BackEnd.Jobs[ jdId=" + jdId + " ]";
    }
    
}
