package Business.User;

import Business.Product.Product;

/**
 *
 * @author neild
 */
public class Admin implements IUser, Observer {

    private String id;
    private String name;
    private String email;
    private String password;

    public Admin(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void resetPassword(String userID) {

    }

    public void deleteProduct(Product p) {

    }

    public void deleteAccount(IUser u) {

    }

    public void searchHistory(IUser u) {

    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
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
    public void update(Product product) {
        System.out.println("Product now available:\n" + product.getId() + " - " + product.getName() + "\nSending email to " + getEmail() + "\n\n");
    }
}
