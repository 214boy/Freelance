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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "OFFERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offers.findAll", query = "SELECT o FROM Offers o"),
    @NamedQuery(name = "Offers.findByOfferId", query = "SELECT o FROM Offers o WHERE o.offerId = :offerId"),
    @NamedQuery(name = "Offers.findByOfferStatus", query = "SELECT o FROM Offers o WHERE o.offerStatus = :offerStatus"),
    @NamedQuery(name = "Offers.getHighestOfferID", query = "SELECT MAX(o.offerId) from Offers o"),
    @NamedQuery(name = "Offers.findByJID", query = "SELECT o FROM Offers o WHERE o.JID = :JID")})
public class Offers implements Serializable {


    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "offerId")
    private Integer offerId;
    @Column(name = "FID")
    private Integer FID;
    @Column(name = "JID")
    private Integer JID;
    @Size(max = 25)
    private String offerStatus;
    
    
    public Offers() {
    }

    public Offers(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getOfferId() {
        return offerId;
    }
    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getFID() {
        return FID;
    }
    public void setFID(Integer FID) {
        this.FID = FID;
    }

    

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }
    
    public Integer getJID() {
        return JID;
    }

    public void setJID(Integer JID) {
        this.JID = JID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerId != null ? offerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offers)) {
            return false;
        }
        Offers other = (Offers) object;
        if ((this.offerId == null && other.offerId != null) || (this.offerId != null && !this.offerId.equals(other.offerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Offers[ freelancerId=" + offerId + " ]";
    }
    
}
