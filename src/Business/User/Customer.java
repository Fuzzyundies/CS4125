package Business.User;

import Business.BusinessManagement.Subscription;
import Business.Product.Product;
import DatabaseManagement.CustomerDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author neild
 */
public class Customer implements ICustomer, IUser, Observer {

    private List<IHistory> userHistory;
    private int rating;
    //private String paymentDetails;
    private int id;
    private String name;
    private String email;
    //private String password;
    //private List<ITransaction> transactions;
    //private ISubscription subscription;
    private Subscription subscription;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int getID() {
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
        return "";//this.password;
    }

    public LocalDate getSubscriptionStart() {
        return subscription.getStartDate();
    }

    public LocalDate getSubscriptionEnd() {
        return subscription.getEndDate();
    }

    public boolean isSubValid() {
        return subscription.getIsActive();
    }

    public int getRating() {
        return rating;
    }

    public String getPaymentDetails() {
        return "";//paymentDetails;
    }

    @Override
    public void setID(int id) {
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
        //this.password = password;
    }

    @Override
    public String toString() {
        return getName() + " : " + getEmail();
    }

    @Override
    public String getCustomer() {
        return this.toString();
    }

    public Product[] getUserHistory() {
        CustomerDAO dbAccess = new CustomerDAO();
        return dbAccess.getHistory(cs4125.CS4125.loggedInUser.getID());
        /*
        userHistory.forEach((history) -> {
            history.showHistory();
        });
         */
    }

    @Override
    public void update(Product product) {
        System.out.println("Product now available:\n" + product.getId() + " - " + product.getName() + "\nSending email to " + getEmail() + "\n\n");
    }

    public void addProductToHistory(Product selectedProduct, int tID, LocalDate sDate, LocalDate eDate) {
        CustomerDAO dbAccess = new CustomerDAO();
        dbAccess.addToHistory(selectedProduct, tID, sDate, eDate);
    }

    public Product[] getLeasedProducts() {
        CustomerDAO dbAccess = new CustomerDAO();
        return dbAccess.getProductsUpForLease(id);
    }
}
