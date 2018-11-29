/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Benjamin Grimes
 */
public class Subscription 
{
    private int subID;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    
    public Subscription(int id, LocalDate startDate, LocalDate endDate)
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

    public LocalDate getStartDate() 
    {
        return startDate;
    }

    public LocalDate getEndDate() 
    {
        return endDate;
    }

    public boolean getIsActive() 
    {
        return isActive;
    }

    public void setSubID(int subID) 
    {
        // TODO implement validation for setSubID method
        this.subID = subID;
    }

    public void setStartDate(LocalDate startDate) 
    {
        // TODO implement validation for setStartDate method
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) 
    {
        // TODO implement validation for setEndDate method
        this.endDate = endDate;
    }

    public void setIsActive(boolean isActive) 
    {
        // TODO implement validation for isIsActive method
        this.isActive = isActive;
    }
    
    public void renew(LocalDate s, LocalDate newEndDate)
    {
        // TODO implement renew method
    }
}
