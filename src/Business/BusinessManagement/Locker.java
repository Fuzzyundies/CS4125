/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import java.util.Date;

/**
 *
 * @author Benjamin Grimes
 */
public class Locker {

    private String renterPin;
    private String leaserPin;
    private Transaction transaction;
    private Date startDate;

    public Locker(String renterPin, String leaserPin, Transaction transaction, Date startDate) {
        this.renterPin = renterPin;
        this.leaserPin = leaserPin;
        this.transaction = transaction;
        this.startDate = startDate;

    }

    public String getRenterPin() {
        return renterPin;
    }

    public String getLeaserPin() {
        return leaserPin;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void reset() {
        // TODO implement reset method
    }
}
