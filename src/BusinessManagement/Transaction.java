/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessManagement;

import java.util.Date;

import User.Customer;

/**
 *
 * @author Benjamin Grimes
 */
public class Transaction 
{
    private String transactionID;
    private Date saleDate;
    private double amount;
    private Customer renter;
    private Customer leaser;
    private String productID;
    
    //builder - debits & credits 
    
    public Transaction(Date saleDate, double amount, Customer renter, 
            Customer leaser, String productID)
    {
        // TODO generate transactionID
        this.transactionID = null;
        this.saleDate = saleDate;
        this.amount = amount;
        this.renter = renter;
        this.leaser = leaser;
        this.productID = productID;
    }

    public String getTransactionID() 
    {
        return transactionID;
    }

    public Date getSaleDate() 
    {
        return saleDate;
    }

    public double getAmount() 
    {
        return amount;
    }

    public Customer getRenter() 
    {
        return renter;
    }

    public Customer getLeaser() 
    {
        return leaser;
    }

    public String getProductID() 
    {
        return productID;
    }

    public void setTransactionID(String transactionID) 
    {
        // TODO implement validation for setTransactionID method
        this.transactionID = transactionID;
    }

    public void setSaleDate(Date saleDate) 
    {
        // TODO implement validation for setSaleDate method
        this.saleDate = saleDate;
    }

    public void setAmount(double amount) 
    {
        // TODO implement validation for setAmount method
        this.amount = amount;
    }

    public void setRenter(Customer renter) 
    {
        // TODO implement validation for setRenter method
        this.renter = renter;
    }

    public void setLeaser(Customer leaser) 
    {
        // TODO implement validation for setLeaser method
        this.leaser = leaser;
    }

    public void setProductID(String productID) 
    {
        // TODO implement validation for setProductID method
        this.productID = productID;
    }
    
    public void applyDiscount(double discount)
    {
        // TODO implement applyDiscount method
    }
}
