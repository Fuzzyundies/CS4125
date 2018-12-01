/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import DatabaseManagement.CustomerDAO;
import java.time.LocalDate;

/**
 *
 * @author Benjamin Grimes
 */

public class Authentication 
{
    private CustomerDAO dbAccess;
    private int customerID;
    
    public Authentication()
    {
        dbAccess = new CustomerDAO();
    }
    
    public boolean checkIfEmailInUse(String email)
    {
        boolean inUse = false;
        
        try 
        {
            inUse = dbAccess.findEmail(email);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return inUse;
    }
    
    public boolean checkIfUsernameInUse(String username)
    {
        boolean inUse = false;
        
        try 
        {
            inUse = dbAccess.findUsername(username);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return inUse;
    }
    
    public void checkForUser(String username, String password)
    {
        customerID = 0;
        System.out.println("Checking DB for user " + username + "...");
        try
        {
            customerID = dbAccess.findCustomer(username, password);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public int getResult()
    {
        return customerID;
    }
    
    public boolean addNewUser(String username, String email, String password, LocalDate s, LocalDate e)
    {
        boolean inserted = false;
        try
        {
            // todo change these to local dates of start and end of subscription
            inserted = dbAccess.addNewCustomer(username, email, password, s, e);
            //Subscription sub = new Subscription(email, s, e);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return inserted;
    }
    
    public LocalDate getStartSubscription(String username)
    {
        LocalDate start =LocalDate.now();
    
        try{
            LocalDate[] l = dbAccess.getSubscriptionDetails(username);
            start = l[0];
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return start;
    }
    
    public LocalDate getEndSubscription(String username)
    {
        LocalDate end = LocalDate.now();
    
        try{
            LocalDate[] l = dbAccess.getSubscriptionDetails(username);
            end = l[1];
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return end;
    }
    
    public boolean getValidSubscription(String email, String username)
    {
        Subscription sub = new Subscription(email, getStartSubscription(username), getEndSubscription(username));
        
        if(sub.getIsActive())
            return true;
        else 
            return false;
    }
}
