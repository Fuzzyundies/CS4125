package User;

import java.util.List;

/**
 *
 * @author neild
 */
public class Customer extends User implements ICustomer {

    //private List<ITransaction> transactions;
    private List<IHistory> userHistory;
    private int rating;
    //private ISubscription subscription;
    private String paymentDetails;

    public Customer(String id, String name, String email, String password, List<IHistory> history) {
        super(id, name, email, password);
        this.userHistory = history;
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
        return super.getName() + " : " + super.getEmail();
    }

    @Override
    public String getCustomer() {
        return this.toString();
    }
}
