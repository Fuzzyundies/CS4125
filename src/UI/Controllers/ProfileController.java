/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

/**
 *
 * @author Eric Lambert
 */
import Business.Product.Product;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.ProfileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sun.security.util.Password;

public class ProfileController {

    private ProfileView profileView;
    private HomeView homeView;

    public ProfileController(ProfileView profileView, HomeView homeView) {
        this.profileView = profileView;
        this.homeView = homeView;
        profileView.addSubscriptionButtonListener(renewSubscriptionListener);
        profileView.addHistBtnListener(viewHistoryActionListener);
        profileView.addEditBtnListener(editProfileListener);
        profileView.addHomeBtnListener(backHomeListener);
    }

    private final ActionListener renewSubscriptionListener = (ActionEvent e) -> {
    };

    private final ActionListener backToProfileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileView.displayProfile();
            profileView.addEditBtnListener(editProfileListener);
            profileView.addHomeBtnListener(backHomeListener);
            profileView.addSubscriptionButtonListener(renewSubscriptionListener);
            profileView.addHistBtnListener(viewHistoryActionListener);
        }
    };

    private ActionListener saveProfileListener = (ActionEvent e) -> {
        String userName = profileView.getNewUserName();
        String password = new String(profileView.getPassword()); //java getPassword() returns char[]
        String confirmPassword = new String(profileView.getConfirmPassword()); //java getPassword() returns char[]
        if (password.equals(confirmPassword) && (password.length() >= 5 && confirmPassword.length() >= 5)) {
            System.out.println("Update this user's profile credentials");
            //updateCredentials(userID, userName, password, confirmPassword);
        } else {
            JOptionPane.showMessageDialog(null, "Passwords must match and contain at least 5 characters.", "Password incompatibility", JOptionPane.ERROR_MESSAGE);
        }
    };

    private ActionListener editProfileListener = (ActionEvent e) -> {
        profileView.createEditProfileWindow();
        profileView.addBackBtnListener(backToProfileListener);
        profileView.addSaveBtnListener(saveProfileListener);
    };

    private ActionListener viewHistoryActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileView.createHistoryWindow();
            profileView.addBackBtnListener(backToProfileListener);
            profileView.addSelectBtnListener(selectProductActionListener);
        }
    };

    private final ActionListener backHomeListener = (ActionEvent e) -> {
        backToHome();
    };

    private ActionListener selectProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = profileView.getSelectedProduct();
            if (p != null) {
                System.out.println("Select product...");
                profileView.displayProductDetails(profileView.getSelectedProduct());
                profileView.addBackBtnListener(backToHistory);
                //profileView.addRentAginListener(); 
                // TODO add option to rent again
                // probably instatiate RentView?
            }
        }
    };

    private ActionListener backToHistory = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileView.createHistoryWindow();
            profileView.addBackBtnListener(backHomeListener);
            profileView.addSelectBtnListener(selectProductActionListener);
        }
    };

    private void backToHome() {
        homeView.setVisible(true);
        profileView.dispose();
    }

}
