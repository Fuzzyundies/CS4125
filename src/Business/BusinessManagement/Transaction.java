/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import java.util.Date;

import Business.User.Customer;
import DatabaseManagement.CustomerDAO;
import DatabaseManagement.ProductDAO;
import DatabaseManagement.TransactionDAO;
import java.time.LocalDate;

/**
 *
 * @author Benjamin Grimes
 */
public class Transaction 
{
    private String transactionID;
    private LocalDate saleDate;
    private double amount;
    private int renterID;
    private int leaserID;
    private int productID;
    
    //builder - debits & credits 
    
    public Transaction(LocalDate saleDate, double amount, int renterID, int productID)
    {
        // TODO generate transactionID
        this.transactionID = null;
        this.saleDate = saleDate;
        this.amount = amount;
        this.renterID = renterID;
        this.productID = productID;
        this.leaserID = getLeaserID();
    }
    
    public int getLeaserID()
    {
        ProductDAO dbAccess = new ProductDAO();
        int lID = dbAccess.getLeaserID(productID);
        return lID;
    }

    public String getTransactionID() 
    {
        return transactionID;
    }

    public LocalDate getSaleDate() 
    {
        return saleDate;
    }

    public double getAmount() 
    {
        return amount;
    }

    public int getRenterID() 
    {
        return renterID;
    }

    public int getProductID() 
    {
        return productID;
    }

    public void setTransactionID(String transactionID) 
    {
        // TODO implement validation for setTransactionID method
        this.transactionID = transactionID;
    }

    public void setSaleDate(LocalDate saleDate) 
    {
        // TODO implement validation for setSaleDate method
        this.saleDate = saleDate;
    }

    public void setAmount(double amount) 
    {
        // TODO implement validation for setAmount method
        this.amount = amount;
    }

    public void setRenter(int renterID) 
    {
        // TODO implement validation for setRenter method
        this.renterID = renterID;
    }

    public void setProductID(int productID) 
    {
        // TODO implement validation for setProductID method
        this.productID = productID;
    }
    
    public void applyDiscount(double discount)
    {
        // TODO implement applyDiscount method
    }
    
    public void executeTransaction()
    {
        TransactionDAO dbAccess = new TransactionDAO();
        
        dbAccess.addTransaction(productID, renterID, leaserID, amount, saleDate, saleDate, renterID, renterID, renterID);
    }
}
