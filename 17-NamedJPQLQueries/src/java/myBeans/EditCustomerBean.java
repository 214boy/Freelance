/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;


import enterpriseBeans.UpdateCustomerBeanLocal;
import entities.Customer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Reiner
 */
@Named(value = "editCustomerBean")
@SessionScoped
public class EditCustomerBean implements Serializable {

    @EJB
    private UpdateCustomerBeanLocal updateCustomerBean;

    private int id;
    private String name;
    private String city;
    private String state;
    private Customer custom;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id Also populates the custom field with the matching
     * Entity object from entity manager and updates fields name, city, state to
     * match entity object.
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
        custom = updateCustomerBean.getCustomer(id);
        if (custom != null) {
            name = custom.getName();
            city = custom.getCity();
            state = custom.getState();
        }
    }

    /**
     * Get the value of custom
     *
     * @return the value of custom
     */
    public Customer getCustom() {
        return custom;
    }

    /**
     * Set the value of custom
     *
     * @param custom new value of custom
     */
    public void setCustom(Customer custom) {
        this.custom = custom;
    }

    /**
     * Get the value of State
     *
     * @return the value of State
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of State
     *
     * @param State new value of State
     */
    public void setState(String State) {
        this.state = State;
    }

    /**
     * Get the value of City
     *
     * @return the value of City
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the value of City
     *
     * @param City new value of City
     */
    public void setCity(String City) {
        this.city = City;
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
     * Creates a new instance of EditCustomerBean
     */
    public EditCustomerBean() {
        id = 1; // ensure id has a valid value
    }

    /**
     * updates the customer object with the supplied values stored in the beans
     * fields.
     *
     * Attention: Container Managed Transaction (CMT) only work in an EJB Either
     * manually control transaction or - often easier - pass on to EJB that
     * supports CMT
     */
    public void update() {
        updateCustomerBean.update(id, name, city, state);
    }

}
