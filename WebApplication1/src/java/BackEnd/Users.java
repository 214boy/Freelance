/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



/**
 *
 * @author eddie
 */
@Named(value = "Users")
@RequestScoped
public class Users {
    private User user;
    private String skill;
    private static ArrayList<User> users = new ArrayList<>();
    private static List<String> skills = new ArrayList<>();
    
    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";
        
    public Users(){
        users = new ArrayList<>();
        skills = new ArrayList<>();
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                    Statement stmt = connect.createStatement();) {
            
              
               ResultSet user_query = stmt.executeQuery(
                        "SELECT * "
                                + "FROM "
                                + "USERS");
               
                while(user_query.next()){
                    user = (new User(user_query.getInt(1), 
                            user_query.getBoolean(2), 
                            user_query.getString(3), 
                            user_query.getString(4),
                            user_query.getString(5),
                            user_query.getString(6),
                            user_query.getDouble(7)));
                    users.add(user);
                }    
    
            } catch (SQLException sql) {
                    System.out.println("User details not found");
                }
    }
    
    //show all users
    public ArrayList<User> getAllUsers() {
        return users;
    }
}
