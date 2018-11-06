/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import java.util.Date;

import Business.Product.Product;

/**
 *
 * @author Benjamin Grimes
 */
public class Locker 
{
    private String renterPin;
    private String leaserPin;
    private Product product;
    private Date startDate;
    
    public Locker(String renterPin, String leaserPin, Product product, Date startDate)
    {
        this.renterPin = renterPin;
        this.leaserPin = leaserPin;
        this.product = product;
        this.startDate = startDate;
        
    }

    public String getRenterPin() 
    {
        return renterPin;
    }

    public String getLeaserPin() 
    {
        return leaserPin;
    }

    public Product getProduct() 
    {
        return product;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    
    public void reset()
    {
        // TODO implement reset method
    }
}
