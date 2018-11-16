package Business.User;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neild
 */
public class CustomerTest {

    private UserFactory userFactory = null;
    private IUser user;

    public CustomerTest() {
        userFactory = new UserFactory();
    }

    /**
     * Test of getID method, of class Customer.
     */
    @Test
    public void testGetID() {
        user = userFactory.getUser("C");
        assertEquals("121", user.getID());
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        user = userFactory.getUser("C");
        assertEquals("cust@mail.ie", user.getEmail());
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        user = userFactory.getUser("C");
        assertEquals("customer", user.getName());
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        user = userFactory.getUser("C");
        assertEquals("pass", user.getPassword());
    }

    /**
     * Test of getRating method, of class Customer.
     */
    @Test
    public void testGetRating() {
    }

    /**
     * Test of getPaymentDetails method, of class Customer.
     */
    @Test
    public void testGetPaymentDetails() {
    }

    /**
     * Test of setID method, of class Customer.
     */
    @Test
    public void testSetID() {

        user = userFactory.getUser("C");
        user.setID("233");
        assertEquals("233", user.getID());
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {

    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName() {

    }

    /**
     * Test of setPassword method, of class Customer.
     */
    @Test
    public void testSetPassword() {

    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
    }

    /**
     * Test of getCustomer method, of class Customer.
     */
    @Test
    public void testGetCustomer() {
    }

    /**
     * Test of rent method, of class Customer.
     */
    @Test
    public void testRent() {
    }

    /**
     * Test of rentOut method, of class Customer.
     */
    @Test
    public void testRentOut() {
    }

    /**
     * Test of getUserHistory method, of class Customer.
     */
    @Test
    public void testGetUserHistory() {
    }

    /**
     * Test of update method, of class Customer.
     */
    @Test
    public void testUpdate() {
    }
}
