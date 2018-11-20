package Business.User;

import java.util.Date;
/**
 *
 * @author thori
 */
public class Subscription implements ISubscription {

    
    private ICustomer user;
    private Date startDate, endDate;
    private boolean isSubscriptionValid;
    
    public Subscription(ICustomer user, Date startDate, Date endDate, boolean subValid)
    {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isSubscriptionValid = subValid;
    }
    
    public String getUser()
    {
        return user.getCustomer();
    }
    
    public Date getStartDate()
    {
        return startDate;
    }
    
    public Date getEndDate()
    {
        return endDate;
    }
    
    public boolean getSubscriptionValid()
    {
        return isSubscriptionValid;
    }
    
    public void setSubscriptionValid(boolean v)
    {
        this.isSubscriptionValid = v;
    }
    
    public void setStartDate(Date sD)
    {
        this.startDate = sD;
    }
    
    public void setEndDate(Date eD)
    {
        this.startDate = eD;
    }
    
    @Override
    public String toString() {
        String valid;
        if(getSubscriptionValid())
            valid = "Valid Subscription";
        else
            valid = "Invalid Subscription";
        
        return getUser() + ": " + getStartDate() + " - " + getEndDate() + valid;
    }
    
    @Override
    public String getSubscription() {
        return this.toString();
    }
    
}
