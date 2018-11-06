/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import Business.Product.Product;
import Business.User.Customer;
import Business.User.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin Grimes
 */
public class Notifcation implements Subject //interface ideally
{

    private List<Observer> observers;
    private final Customer renter;
    private final Customer leaser;

    public Notifcation(Customer renter, Customer leaser) {
        this.renter = renter;
        this.leaser = leaser;
        this.observers = new ArrayList();
    }

    public Customer getRenter() {
        return renter;
    }

    public Customer getLeaser() {
        return leaser;
    }

    public void sendEmail(Customer r, Customer l) {
        // TODO implement sendEmail method
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("Adding observer..\n");
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(observers.indexOf(o));
        System.out.println("Observer removed..\nLength of queue - " + observers.size());
    }

    @Override
    public void notify(Product product) {
        for (Observer o : observers) {
            o.update(product);
        }
    }

    public void notifyProductReturned(Product product) {
        notify(product);
    }

}
