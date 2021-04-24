/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseBeans;

import entities.Profile;
import javax.ejb.Local;

/**
 *
 * @author Reiner
 */
@Local
public interface UpdateProfileBeanLocal {
    public void update(int id, String name, boolean loggedin, String password);
    public Profile getProfile(int id);
    public void Loggedin(Profile profile);
    public void Loggedout();
}
