/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Customer;
import entities.DiscountCode;
import entities.MicroMarket;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Reiner
 */
@Stateless
public class NewCustomerBean implements NewCustomerBeanLocal {

    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;

    /**
     * Adds a new customer to the database with given name and city. Note:
     * Required foreign keys DiscountCode and MicroMarket for the table Customer
     * are fixed in this example.
     *
     * @param name New name for new customer
     * @param city City for new customer
     * @param state State for new customer
     * @return ID of newly created customer
     */
    public int createCustomer(String name, String city, String state) {
        int id = (Integer) em.createNamedQuery("Customer.getHighestCustomerID").getSingleResult();
        // id is current highest, increment to next id
        id++;
        // create customer object
        Customer c = new Customer(id);

        // ensure all constraints are fulfilled before making object persistent
        // set discount to none
        c.setDiscountCode((DiscountCode) em.createNamedQuery("DiscountCode.findByDiscountCode").
                setParameter("discountCode", "N").getSingleResult());

        // set default ZIP code
        c.setZip((MicroMarket) em.createNamedQuery("MicroMarket.findByZipCode").
                setParameter("zipCode", "10095").getSingleResult());

        // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(c);
        // set city and name and state
        c.setCity(city);
        c.setName(name);
        c.setState(state);

        // return id of new customer
        return id;

    }

    /**
     * make the passed object persistent
     *
     * @param object object to be made persistent
     */
    public void persist(Object object) {
        em.persist(object);
    }
}
