/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import enterpriseBeans.NewCustomerBeanLocal;
import enterpriseBeans.UpdateCustomerBeanLocal;
import entities.Customer;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Reiner
 */
@Named(value = "addCustomerBean")
@RequestScoped
public class AddCustomerBean {

    @EJB
    private NewCustomerBeanLocal newCustomerBean;

    private String name;
    private String city;
    private String state;
    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
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
     * Creates a new customer with name, city, state stored in this bean
     */
    public void create() {
        id = newCustomerBean.createCustomer(name, city, state);
    }

    /**
     * Creates a new instance of AddCustomerBean
     */
    public AddCustomerBean() {
        id = 0;
    }
    
    public String notification() {
        if (id == 0) return "";
        else return "New user with id " + id + " created!!!";
    }

}
