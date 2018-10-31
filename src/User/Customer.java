package User;

import java.util.List;

/**
 *
 * @author neild
 */
public class Customer implements ICustomer, User {

    //private List<ITransaction> transactions;
    private List<IHistory> userHistory;
    private int rating;
    //private ISubscription subscription;
    private String paymentDetails;
    private final String id;
    private String name, email, password;

    public Customer(String id, String name, String email, String password, List<IHistory> history) {
        this.userHistory = history;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void rent(/*Product p*/) {

    }

    public void rentOut(/*Product p*/) {

    }

    public void getUserHistory() {
        userHistory.forEach((history) -> {
            history.showHistory();
        });
    }

    @Override
    public String toString() {
        return getName() + " : " + getEmail();
    }

    @Override
    public String getCustomer() {
        return this.toString();
    }

    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
