/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Reiner
 */
@Stateless
public class UpdateCustomerBean implements UpdateCustomerBeanLocal {

    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;

    /**
     * updates an existing customer
     * 
     * @param id ID of customer to be updated
     * @param name new name for customer
     * @param city new city for customer
     * @param state new state for customer
     */
    @Override
    public void update(int id, String name, String city, String state) {
        Customer custom = getCustomer(id);
        if (custom != null) {
            custom.setName(name);
            custom.setCity(city);
            custom.setState(state);
        }
    }

    /**
     * Returns an entity object of customer with given id
     * 
     * @param id ID of customer to be returned
     * @return Customer object with id 
     */
    @Override
    public Customer getCustomer(int id) {
        // create named query and set parameter
        Query query = em.createNamedQuery("Customer.findByCustomerId")
                .setParameter("customerId", id);
        List<Customer> result = query.getResultList();
        return result.get(0);
    }

    /**
     * make the passed object persistent
     * @param object object to be made persistent
     */
    public void persist(Object object) {
        em.persist(object);
    }

}
