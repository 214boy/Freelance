/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;


import enterpriseBeans.UpdateProfileBeanLocal;
import entities.Profile;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Reiner
 */
@Named(value = "editProfileBean")
@SessionScoped
public class EditProfileBean implements Serializable {

    @EJB
    private UpdateProfileBeanLocal updateProfileBean;

    private int uid;
    private String name;
    private boolean loggedin;
    private String password;
    private Profile custom;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return uid;
    }

    /**
     * Set the value of id Also populates the custom field with the matching
     * Entity object from entity manager and updates fields name, loggedin, password to
     * match entity object.
     *
     * @param uid new value of id
     */
    public void setUid(int uid) {
        this.uid = uid;
        custom = updateProfileBean.getProfile(uid);
        if (custom != null) {
            name = custom.getName();
            loggedin = custom.getLoggedin();
            password = custom.getPassword();
        }
    }

    /**
     * Get the value of custom
     *
     * @return the value of custom
     */
    public Profile getCustom() {
        return custom;
    }

    /**
     * Set the value of custom
     *
     * @param custom new value of custom
     */
    public void setCustom(Profile custom) {
        this.custom = custom;
    }

    /**
     * Get the value of State
     *
     * @return the value of State
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of State
     *
     * @param password new value of State
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of Loggedin
     *
     * @return the value of loggedin
     */
    public boolean getLoggedin() {
        return loggedin;
    }

    /**
     * Set the value of loggedin
     *
     * @param loggedin new value of loggedin
     */
    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of EditProfileBean
     */
    public EditProfileBean() {
        uid = 1; // ensure id has a valid value
    }

    /**
     * updates the profile object with the supplied values stored in the beans
     * fields.
     *
     * Attention: Container Managed Transaction (CMT) only work in an EJB Either
     * manually control transaction or - often easier - pass on to EJB that
     * supports CMT
     */
    public void update() {
        updateProfileBean.update(uid, name, loggedin, password);
    }
    
    public void Loggedin(Profile profile) {
        updateProfileBean.Loggedin(profile);
    }
    

}
