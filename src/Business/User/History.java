package Business.User;

import java.util.Date;
import java.util.List;

/**
 *
 * @author neild
 */
public class History implements IHistory {

    private ICustomer renter, leaser;
    private Date startDate, endDate;
    private List<Date> dates;

    public History(ICustomer renter, ICustomer leaser, Date startDate, Date endDate) {
        this.renter = renter;
        this.leaser = leaser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRenter() {
        return renter.getCustomer();
    }

    public void setRenter(ICustomer renter) {
        this.renter = renter;
    }

    public String getLeaser() {
        return leaser.getCustomer();
    }

    public void setLeaser(ICustomer leaser) {
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

    @Override
    public void showHistory() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Renter = { " + renter.toString() + "}\nLeaser = {" + leaser.toString() + "}\nStartDate = {" + startDate.toString()
                + "}\nEndDate = {" + endDate.toString() + "}\nDates = {" + dates.toString() + "}";
    }
}
