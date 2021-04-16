/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;
import javax.inject.Named;

/**
 *
 * @author Fiachra
 */

@Named(value = "ViewEditBean")
@RequestScoped
public class ViewEditJobs implements Serializable{
    private static ArrayList<Job> Jobs = new ArrayList<>();
    private static ArrayList<Job> Offers = new ArrayList<>();
    private Job Job; 
    private Job Offer; 
    
    private static final String URL = "jdbc:derby://localhost:1527/sample";
    private static final String USER = "app";
    private static final String PASSWD = "app";
    
    //Get all jobs and store in array
    public ViewEditJobs(){
            Jobs = new ArrayList<>(); // set jobs to none; 


    }
    
    public void getOffers(){
        Offers = new ArrayList<>(); // set jobs to none;
   
        
    }
   
    //remove job descp (ensure Provider ID to ensure only current provider can delete)
    public void removeJob(int PID, int JD_ID){
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
            Statement stmt = connect.createStatement();) {
            // execute statement - note DB needs to perform full processing
           // on calling executeQuery
           String query1 = "DELETE FROM KEYWORDS WHERE JOBID=" + Integer.toString(JD_ID) +
                           " AND " + Integer.toString(PID) ;
           String query2 = "DELETE FROM OFFERS WHERE JOBID=" + Integer.toString(JD_ID) +
                           " AND " + Integer.toString(PID) ;
           String query3 = "DELETE FROM JOBS WHERE JOBID=" + Integer.toString(JD_ID) +
                           " AND " + Integer.toString(PID) ;

                stmt.executeUpdate(query1);
                stmt.executeUpdate(query2);
                stmt.executeUpdate(query3);
                
                System.out.println("Job #" + JD_ID + " deleted");
              
            } catch (SQLException sql) {
                // if list is empty, add single value
                if (Jobs.isEmpty()) {
                System.out.println("Not deleted");
                }
            }
    }
    
    //accpet freelancer (will also close job)
    //FID to be used for logging
    public void acceptFreelancer(String status, int JD_ID, int FID) { 
        String newStatus = "Open"; // default value
       
        if (status.equals("Open")) {
            newStatus = "Closed";
        } else if(status.equals("Closed")) {
            newStatus = "Open";
        } 
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWD);
                Statement stmt = connect.createStatement();) {
            // execute statement - note DB needs to perform full processing
            // on calling executeQuery
            String query = "UPDATE JOBS SET STATUS='" + newStatus + 
                    "' WHERE JOBID=" + Integer.toString(JD_ID);
            stmt.executeUpdate(query);


        } catch (SQLException sql) {
            // if list is empty, add single value
            if (Jobs.isEmpty()) {
            System.out.println("Not updated");
            }
        }
        System.out.println(FID + " Freelancer accepted");
    }
    
    //show all jobs
    public ArrayList<Job> getAllJobs() {
        return Jobs;
    }
    //view open offers
    public ArrayList<Job> getAllOffers() {
        return Offers;
    }
}
