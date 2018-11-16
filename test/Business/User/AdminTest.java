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
public class AdminTest {

    private UserFactory userFactory = null;
    private IUser user;

    public AdminTest() {
        userFactory = new UserFactory();
    }

    @Test
    public void testResetPassword() {
    }

    @Test
    public void testDeleteProduct() {
    }

    @Test
    public void testDeleteAccount() {
    }

    @Test
    public void testSearchHistory() {
    }

    @Test
    public void testGetID() {
        user = userFactory.getUser("A");
        assertEquals("101", user.getID());
    }

    @Test
    public void testGetEmail() {
        //Purposely fail this test
        user = userFactory.getUser("A");
        assertEquals("someEmail@mail.ie", user.getEmail());
    }

    @Test
    public void testGetName() {
    }

    @Test
    public void testGetPassword() {
    }

    @Test
    public void testSetID() {
    }

    @Test
    public void testSetEmail() {
    }

    @Test
    public void testSetName() {
    }

    @Test
    public void testSetPassword() {
    }

    @Test
    public void testUpdate() {
    }

}
