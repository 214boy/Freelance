/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eddie
 */
@Entity
@Table(name = "PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByUid", query = "SELECT p FROM Profile p WHERE p.uid = :uid"),
    @NamedQuery(name = "Profile.findByFlance", query = "SELECT p FROM Profile p WHERE p.flance = :flance"),
    @NamedQuery(name = "Profile.findByProv", query = "SELECT p FROM Profile p WHERE p.prov = :prov"),
    @NamedQuery(name = "Profile.findByAdm", query = "SELECT p FROM Profile p WHERE p.adm = :adm"),
    @NamedQuery(name = "Profile.findByName", query = "SELECT p FROM Profile p WHERE p.name = :name"),
    @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email"),
    @NamedQuery(name = "Profile.findBySkills", query = "SELECT p FROM Profile p WHERE p.skills = :skills"),
    @NamedQuery(name = "Profile.findByDescription", query = "SELECT p FROM Profile p WHERE p.description = :description"),
    @NamedQuery(name = "Profile.findByBalance", query = "SELECT p FROM Profile p WHERE p.balance = :balance"),
    @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password"),
    @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password"),
    @NamedQuery(name = "Profile.getHighestProfileID", query = "SELECT MAX(p.uid) from Profile p")})

public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UID")
    private Integer uid;
    @Column(name = "FLANCE")
    private Boolean flance;
    @Column(name = "PROV")
    private Boolean prov;
    @Column(name = "ADM")
    private Boolean adm;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "SKILLS")
    private String skills;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BALANCE")
    private Double balance;
    @Size(max = 30)
    @Column(name = "PASSWORD")
    private String password;

    public Profile() {
    }

    public Profile(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getFlance() {
        return flance;
    }

    public void setFlance(Boolean flance) {
        this.flance = flance;
    }

    public Boolean getProv() {
        return prov;
    }

    public void setProv(Boolean prov) {
        this.prov = prov;
    }

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profile[ uid=" + uid + " ]";
    }
    
}
