package Business.User;

/**
 *
 * @author neild
 */

public interface IUser {
    int getID();
    String getEmail();
    String getName();
    String getPassword();
    void setID(int id);
    void setEmail(String email);
    void setName(String name);
    void setPassword(String password);
}