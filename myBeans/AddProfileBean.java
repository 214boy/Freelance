/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import enterpriseBeans.NewProfileBeanLocal;
import enterpriseBeans.UpdateProfileBeanLocal;
import entities.Profile;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Reiner
 */
@Named(value = "addProfileBean")
@RequestScoped
public class AddProfileBean {

    @EJB
    private NewProfileBeanLocal newProfileBean;

    private int uid;
    private boolean flance;
    private boolean prov;
    private boolean adm;
    private String name;
    private String email;
    private String skills;
    private String description;
    private double balance;
    private String password;
    
    

    /**
     * Get the value of id
     *
     * @return the value of id
     */
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

    /**
     * Creates a new customer with name, city, state stored in this bean
     */
    public void create() {
        uid = newProfileBean.createProfile(flance, prov, adm,
             name, email, skills, description,
             balance, password);
    }

    /**
     * Creates a new instance of AddCustomerBean
     */
    public AddProfileBean() {
        uid = 0;
    }
    
    public String notification() {
        if (uid == 0) return "";
        else return "New user with id " + uid + " created!!!";
    }

}
