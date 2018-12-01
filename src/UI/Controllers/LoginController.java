/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import Business.BusinessManagement.Authentication;
import Business.BusinessManagement.Subscription;
import Business.User.Customer;
import DatabaseManagement.CustomerDAO;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjamin Grimes
 */
public class LoginController {

    private final LoginView loginView;
    private final Authentication authenticationModel;

    public LoginController(LoginView view, Authentication model) {
        this.loginView = view;
        this.authenticationModel = model;
        view.addLoginBtnListener(new LoginBtnListener());
        view.addSignUpBtnListener(new SignUpBtnListener());
    }

    private void backToLogin() {
        loginView.displayLoginView();
        loginView.addLoginBtnListener(new LoginBtnListener());
        loginView.addSignUpBtnListener(new SignUpBtnListener());
    }

    class LoginBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = "";
            String password = "";

            try {
                username = loginView.getName();
                password = loginView.getPassword();

                authenticationModel.checkForUser(username, password);
                int result = authenticationModel.getResult();

                if (result <= 0) {
                    loginView.displayErrorMessage("User not found");
                } else {

                    //cs4125.CS4125.userID = result;
                    CustomerDAO dbAccess = new CustomerDAO();
                    //cs4125.CS4125.username = dbAccess.getUsername(cs4125.CS4125.userID);
                    //cs4125.CS4125.email = dbAccess.getEmail(cs4125.CS4125.userID);
                    cs4125.CS4125.loggedInUser = new Customer(result, dbAccess.getUsername(result), dbAccess.getEmail(result));
                    //System.out.println("UserID:" + cs4125.CS4125.userID + " Username:" + cs4125.CS4125.username + " email:" + cs4125.CS4125.email);

                    //if(SubscriptionValid())
                    //{
                    HomeView homeView = new HomeView();
                    HomeController homeController = new HomeController(homeView, loginView, authenticationModel);
                    //}
                    //else
                    //Go to renew subscription page
                    //To do 

                    loginView.setVisible(false);
                }
            } catch (Exception ex) {
                loginView.displayErrorMessage("Error loggin in");
            }
        }
    }

    /*
    public boolean SubscriptionValid()
    {
        -get customer endDate
        -if endDate before currentDate return false
        -if endDate after currentDate return true
    }
     */

    class SignUpBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginView.displaySignUpView();
            loginView.addCancelBtnListener(new CancelBtnListener());
            loginView.addConfirmBtnListener(new ConfirmBtnListner());
        }
    }

    class CancelBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Back to login");
            backToLogin();
        }

    }

    class ConfirmBtnListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getName();
            String email = loginView.getEmail();
            String password = loginView.getPassword();

            boolean inUse = authenticationModel.checkIfEmailInUse(email);

            if (inUse) {
                loginView.displayErrorMessage("Email is in use");
            } else {
                inUse = authenticationModel.checkIfUsernameInUse(username);
                if (inUse) {
                    loginView.displayErrorMessage("Username is in use");
                } else {
                    // Create new customer
                    //Validate CreditCard, take in 1234 as valid
                    int cC;
                    try {
                        cC = Integer.parseInt(loginView.getCreditCard());
                        if (cC == 1234) //creditCard is valid
                        {
                            //create subscription for that user, setting start date to current date

                            LocalDate sDate = LocalDate.now();
                            LocalDate eDate = LocalDate.now().plusMonths(3);
                            //LocalDate eDate = LocalDate.now().minusDays(3);   //for testing if a subscription is valid or not

                            authenticationModel.addNewUser(username, email, password, sDate, eDate);

                            backToLogin();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(loginView, "Please enter credit card details", "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

}
