/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBeans;

import entities.Jobs;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lunch
 */
@Named(value = "showKeywordsBean")
@RequestScoped
public class showByKeywords {
      
    @PersistenceContext(unitName = "04-DynamicJPQLQueriesPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    private String keywords;
    /**
     * Creates a new instance of showJobBean
     */
    public showByKeywords() {
    }

    
    /**
     * Getter for customerCity
     * @return value of customerCity
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Setter for customerCity
     * @param customerCity new value for customerCity
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    
    /**
     * Returns list of customer with a given name
     * 
     * @return All customer with name customerName
     */
    public List<Jobs> getAllKeywords() {
        // create named query and set parameter
        Query query = em.createNamedQuery(
                "Jobs.findByKeywords1")
                .setParameter("keywords1", keywords);
        Query query2 = em.createNamedQuery(
                "Jobs.findByKeywords2")
                .setParameter("keywords2", keywords);
        Query query3 = em.createNamedQuery(
                "Jobs.findByKeywords3")
                .setParameter("keywords3", keywords);
        List<Jobs> QueryList1 = query.getResultList();
        List<Jobs> QueryList2 = query2.getResultList();
        List<Jobs> QueryList3 = query3.getResultList();
        
        List<Jobs> newList = new ArrayList<>(QueryList1.size() + QueryList2.size()
                                               + QueryList3.size());
            newList.addAll(QueryList1);
            newList.addAll(QueryList2); 
            newList.addAll(QueryList3);
        // return query result
        return newList;
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
