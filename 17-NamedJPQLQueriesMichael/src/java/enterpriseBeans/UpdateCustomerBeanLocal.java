/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Customer;
import javax.ejb.Local;

/**
 *
 * @author Reiner
 */
@Local
public interface UpdateCustomerBeanLocal {
    public void update(int id, String name, String city, String state);
    public Customer getCustomer(int id);
}
