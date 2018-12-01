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
import Business.BusinessManagement.Authentication;
import Business.Product.Product;
import DatabaseManagement.CustomerDAO;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.ProfileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

    private ActionListener saveProfileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = profileView.getNewUserName();
            String email = profileView.getNewEmail();
            String password = new String(profileView.getPassword()); //java getPassword() returns char[]
            String confirmPassword = new String(profileView.getConfirmPassword()); //java getPassword() returns char[]

            Authentication authenticationModel = new Authentication();
            boolean emailInUse = authenticationModel.checkIfEmailInUse(email);
            boolean usernameInUse = authenticationModel.checkIfUsernameInUse(userName);
            if (emailInUse) {
                JOptionPane.showMessageDialog(profileView, "Email entered is already in use");
            } else if (usernameInUse) {
                JOptionPane.showMessageDialog(profileView, "Username is already in use");
            } else if (password.equals(confirmPassword) && (password.length() >= 5 && confirmPassword.length() >= 5) && !userName.isEmpty() && !emailInUse && !usernameInUse) {
                CustomerDAO dbAccess = new CustomerDAO();
                try {
                    dbAccess.updateProfile(userName, email, password);
                    JOptionPane.showMessageDialog(profileView, "Profile details have been updated", "Profile Updated", 1);
                    // Go back to profile 
                    profileView.displayProfile();
                    profileView.addEditBtnListener(editProfileListener);
                    profileView.addHomeBtnListener(backHomeListener);
                    profileView.addSubscriptionButtonListener(renewSubscriptionListener);
                    profileView.addHistBtnListener(viewHistoryActionListener);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Passwords must match, contain at least 5 characters and Username cannot be empty", "Password incompatibility", JOptionPane.ERROR_MESSAGE);
            }
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

    private ActionListener renewSubscriptionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //In here need to renew the subscription
            profileView.createRenewSubscriptionWindow();
            profileView.addBackBtnListener(backToProfileListener);
            profileView.addRenewBtnListener(renewListener);
        }
    };

    private ActionListener renewListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Renew Listener");
            //To do -- Validate credit card
            try {
                if (Integer.parseInt(profileView.getCreditCard()) == 1234) {
                    //setting up new subscription for that user
                    JOptionPane.showMessageDialog(profileView, "Subscription renewed for 3 months");
                    backToHome();
                } else {
                    JOptionPane.showMessageDialog(profileView, "Incorrect Credit Card details");
                    profileView.clearCreditCard();
                }
            } catch (NumberFormatException ex) {

            }
        }
    };

    private final ActionListener backHomeListener = (ActionEvent e) -> {
        backToHome();
    };

    private ActionListener rateUserListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Rate user");
        }
    };

    private ActionListener selectProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = profileView.getSelectedProduct();
            if (p != null) {
                System.out.println("Select product...");
                profileView.displayProductDetails(profileView.getSelectedProduct());
                profileView.addBackBtnListener(backToHistory);
                profileView.addRateUserListener(rateUserListener);
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
