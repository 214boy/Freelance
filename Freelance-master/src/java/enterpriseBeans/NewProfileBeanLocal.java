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
public interface NewProfileBeanLocal {
     public int createProfile(boolean flance, boolean prov,boolean adm,
             String name, String email, String skills, String description,
             double balance, String password);
}
