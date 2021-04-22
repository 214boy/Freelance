/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import javax.ejb.Local;

/**
 *
 * @author Reiner
 */
@Local
public interface NewCustomerBeanLocal {
     public int createCustomer(String name, String city, String state);
}
