package Business.User;

import java.util.List;

/**
 *
 * @author neild
 */
public class Customer implements ICustomer, IUser {

    private List<IHistory> userHistory;
    private int rating;
    private String paymentDetails;
    private String id;
    private String name;
    private String email;
    private String password;
    //private List<ITransaction> transactions;
    //private ISubscription subscription;

    public Customer(String id, String name, String email, String password, List<IHistory> history) {
        this.userHistory = history;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public int getRating() {
        return rating;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getName() + " : " + getEmail();
    }

    @Override
    public String getCustomer() {
        return this.toString();
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

    //WOW FACTORS = NOT COVERED IN LECTURES
    //lambda exoressions to support extensibility
    //aws
    //cool design
}
