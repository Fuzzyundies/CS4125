/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessManagement;

import java.util.Date;

/**
 *
 * @author Benjamin Grimes
 */
public class Subscription 
{
    private int subID;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    
    public Subscription(int id, Date startDate, Date endDate)
    {
        this.subID = id;
        this.startDate = startDate;
        this.endDate = endDate;
        isActive = true;
    }

    public int getSubID() 
    {
        return subID;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public boolean isIsActive() 
    {
        return isActive;
    }

    public void setSubID(int subID) 
    {
        // TODO implement validation for setSubID method
        this.subID = subID;
    }

    public void setStartDate(Date startDate) 
    {
        // TODO implement validation for setStartDate method
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) 
    {
        // TODO implement validation for setEndDate method
        this.endDate = endDate;
    }

    public void setIsActive(boolean isActive) 
    {
        // TODO implement validation for isIsActive method
        this.isActive = isActive;
    }
    
    public void renew(Date s, Date newEndDate)
    {
        // TODO implement renew method
    }
}
