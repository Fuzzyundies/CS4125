<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.User;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neild
 */
public class CustomerTest {
    
    public CustomerTest() {
    }

    /**
     * Test of getID method, of class Customer.
     */
    @Test
    public void testGetID() {
        final String testID = "121";
        Customer customer = new Customer(testID, "neil", "neil@mail.ie", "TestPassword", null);
        assertEquals(testID, customer.getID());
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        final String testEmail = "test@mail.ie";
        Customer customer = new Customer("", "TestName", testEmail, "TestPassword", null);
        assertEquals(testEmail, customer.getEmail());
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        final String testName = "TestName";
        Customer customer = new Customer("", testName, "neil@mail.ie", "TestPassword", null);
        assertEquals(testName, customer.getName());
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        final String testPassword = "TestPassword";
        Customer customer = new Customer("", "TestName", "neil@mail.ie", testPassword, null);
        assertEquals(testPassword, customer.getPassword());
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
        Customer customer = new Customer("101", "TestName", "neil@mail.ie", "password", null);
        customer.setID("103");
        assertEquals("103", customer.getID());
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        Customer customer = new Customer("", "TestName", "neil@mail.ie", "password", null);
        customer.setEmail("new@mail.ie");
        assertEquals("new@mail.ie", customer.getEmail());
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName() {
        Customer customer = new Customer("", "TestName", "neil@mail.ie", "pass", null);
        customer.setName("newName");
        assertEquals("newName", customer.getName());
    }

    /**
     * Test of setPassword method, of class Customer.
     */
    @Test
    public void testSetPassword() {
        Customer customer = new Customer("", "TestName", "neil@mail.ie", "password", null);
        customer.setPassword("newPass");
        assertEquals("newPass", customer.getPassword());
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        user = userFactory.createUser("C");
        assertEquals("121", user.getID());
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        user = userFactory.createUser("C");
        assertEquals("cust@mail.ie", user.getEmail());
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        user = userFactory.createUser("C");
        assertEquals("customer", user.getName());
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        user = userFactory.createUser("C");
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
        
        user = userFactory.createUser("C");
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
>>>>>>> b9b054b7f12a6253785d6cd209f8accf3ba47128
