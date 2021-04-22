/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import entities.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author reiner.dojen
 */
@Named(value = "showCustomerBean")
@RequestScoped
public class ShowCustomerBean {
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    private String customerName;
    private String customerCity;
    
    /**
     * Creates a new instance of ShowCustomerBean
     */
    public ShowCustomerBean() {
    }

    /**
     * Returns list of customer with a given name
     * 
     * @return All customer with name customerName
     */
    public List<Customer> getCustomerByName() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Customer.findByName")
                .setParameter("name", customerName);
        // return query result
        return query.getResultList();
    }

    /**
     * Returns a list of customer from a given city
     * 
     * @return List of customers in a city
     */
    public List<Customer> getCustomerByCity() {

        // create named query and set parameter
        Query query = em.createNamedQuery("Customer.findByCity")
                .setParameter("city", customerCity);
        // return query result
        return query.getResultList();
    }
    
    /**
     * Getter for customerName
     * @return value of customerName 
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter for customerName
     * @param customerName new value for customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter for customerCity
     * @return value of customerCity
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Setter for customerCity
     * @param customerCity new value for customerCity
     */
    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    /**
     * Auto-generated method for managing access to persist method
     * of entity manager
     * 
     * @param object Object to be made persistent
     */
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    
}
