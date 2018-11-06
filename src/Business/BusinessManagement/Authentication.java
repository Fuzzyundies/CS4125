/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import DatabaseManagement.CustomerDAO;

/**
 *
 * @author Benjamin Grimes
 */
public class Authentication 
{
    CustomerDAO dbAccess;
    private int result;
    
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
        result = 0;
        System.out.println("Checking DB for user " + username + "...");
        try
        {
            result = dbAccess.findCustomer(username, password);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public int getResult()
    {
        return result;
    }
    
    public boolean addNewUser(String username, String email, String password)
    {
        boolean inserted = false;
        try
        {
            inserted = dbAccess.insert(username, email, password);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return inserted;
    }
}
