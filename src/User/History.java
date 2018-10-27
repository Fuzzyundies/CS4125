package User;

import java.util.Date;
import java.util.List;

/**
 *
 * @author neild
 */
public class History {
    private Customer renter, leaser;
    private Date startDate, endDate;
    private List<Date> dates;

    public History(Customer renter, Customer leaser, Date startDate, Date endDate) {
        this.renter = renter;
        this.leaser = leaser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Customer getRenter() {
        return renter;
    }

    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    public Customer getLeaser() {
        return leaser;
    }

    public void setLeaser(Customer leaser) {
        this.leaser = leaser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public void addDate(Date d) {
        dates.add(d);
    }

    
}
