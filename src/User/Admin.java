package User;

/**
 *
 * @author neild
 */
public class Admin implements User {

    private final String id;
    private final String name;
    private final String email;
    private final String password;
    //private DBManager dbHelper;
    
    public Admin(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void resetPassword(String userID) {

    }

    public void deleteProduct(/*Product p*/) {

    }

    public void deleteAccount(User u) {

    }

    public void searchHistory(User u) {

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
}
