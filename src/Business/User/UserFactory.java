package Business.User;

/**
 *
 * @author neild
 */
public class UserFactory {

    public IUser getUser(final String userType) {
        IUser user = null;
        switch (userType) {
            case "C":
                user = new Customer("121", "customer", "cust@mail.ie", "pass", null);
                break;
            case "A":
                user = new Admin("101", "admin", "admin@mail.ie", "pass");
                break;
        }
        return user;
    }
}
