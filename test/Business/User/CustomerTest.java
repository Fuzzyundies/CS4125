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
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        final String testEmail = "test@mail.ie";
        Customer customer = new Customer("", "TestName", testEmail, "TestPassword", null);
        assertEquals("16170008@mail.ie", customer.getEmail());
        assertEquals(testEmail, customer.getEmail());
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
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
