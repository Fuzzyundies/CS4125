package Business.User;

import java.time.LocalDate;

/**
 *
 * @author neild
 */
public class UserFactory {

    public IUser getUser(final String userType) {
        IUser user = null;
        switch (userType) {
            case "C":
                user = new Customer("121", "customer", "cust@mail.ie", "pass", null, LocalDate.now(), LocalDate.now());
                break;
            case "A":
                user = new Admin("101", "admin", "admin@mail.ie", "pass");
                break;
        }
        return user;
    }
}
