/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessManagement;

import User.Customer;

/**
 *
 * @author Benjamin Grimes
 */
public class Notifcation 
{
    private final Customer renter;
    private final Customer leaser;
    
    public Notifcation(Customer renter, Customer leaser)
    {
        this.renter = renter;
        this.leaser = leaser;
    }
    
    public Customer getRenter()
    {
        return renter;
    }
    
    public Customer getLeaser()
    {
        return leaser;
    }
    
    public void sendEmail(Customer r, Customer l)
    {
        // TODO implement sendEmail method
    }
    
    
}
