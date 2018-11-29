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
        if(this.startDate.isBefore(startDate))      
            System.out.println("Current Startdate before new StartDate");
        else if(this.startDate.equals(startDate))
            System.out.println("Current Startdate equal to new StartDate");
        else
            this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) 
    {
        if(this.endDate.isBefore(this.startDate))
            System.out.println("New Enddate after current StartDate");
        else if(this.endDate.isAfter(endDate))
            System.out.println("Current Enddate after new EndDate");
        else 
            this.endDate = endDate;
    }

    public void setIsActive(boolean isActive) 
    {
        if(this.endDate.isBefore(LocalDate.now()) && isActive)
        {
            System.out.println("Current EndDate expired");
            this.isActive = !isActive;
        }
        else if(this.startDate.isAfter(LocalDate.now()) && isActive)
        {
            System.out.println("Current Startdate not started yet");
            this.isActive = !isActive;
        }
        else if((this.startDate.isEqual(LocalDate.now()) || this.startDate.isBefore(LocalDate.now()) && this.endDate.isAfter(LocalDate.now())))
            this.isActive = isActive;
    }
    
    public void renew(LocalDate s, LocalDate newEndDate)
    {
        // TODO implement renew method
        if((s.isEqual(LocalDate.now()) || s.isBefore(LocalDate.now()) && newEndDate.isAfter(LocalDate.now())))
        {
            this.startDate = s;
            this.endDate = newEndDate;
            this.isActive = true;
        }
        
    }
}
