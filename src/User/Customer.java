package User;

import java.util.List;

/**
 *
 * @author neild
 */
public class Customer extends User {
    
    //private List<ITransaction> transactions;
    //private List<IHistory> history;
    private int rating;
    //private ISubscription subscription;
    private String paymentDetails;
    
    public Customer(String id, String name, String email, String password) {
        super(id, name, email, password);
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
}
