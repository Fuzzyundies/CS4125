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
}
