/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import Business.BusinessManagement.Authentication;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.ProfileView;
import UI.UserInterfaces.RentOutView;
import UI.UserInterfaces.RentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjamin Grimes
 */
public class HomeController {

    private HomeView homeView;
    private LoginView loginView;
    private Authentication authModel;
    private boolean isSubValid;

    public HomeController(HomeView view, LoginView loginView, Authentication a) {
        this.homeView = view;
        this.loginView = loginView;
        this.authModel = a;
        isSubValid = authModel.getValidSubscription(cs4125.CS4125.email, cs4125.CS4125.username);
        view.addRentListener(rentActionListener);
        view.addRentOutListener(rentOutActionListener);
        view.addViewProfileListener(viewProfileActionListener);
        view.addSignOutListener(signOutActionListener);
    }

    private final ActionListener rentActionListener = (ActionEvent e) -> {
        //Go to RentView
        if (isSubValid) {
            RentView rentView = new RentView();
            RentController rentViewController = new RentController(rentView, homeView);
            homeView.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Renew Your Subscription.");
        }
    };

    private final ActionListener rentOutActionListener = (ActionEvent e) -> {
        //Go to RentOutView 
        if (isSubValid) {
            RentOutView rentOutView = new RentOutView();
            RentOutController rentOutController = new RentOutController(rentOutView, homeView);
            homeView.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Renew Your Subscription.");
        }
    };

    private final ActionListener viewProfileActionListener = (ActionEvent e) -> {
        String temp = "temp";
        Double temp2 = 2.0;
        ProfileView profileView = new ProfileView(temp, temp2);
        ProfileController profileController = new ProfileController(profileView, homeView);
        homeView.setVisible(false);
    };

    private final ActionListener signOutActionListener = (ActionEvent e) -> {
        loginView.dispose();
        LoginView loginView = new LoginView();
        Authentication authenticationModel = new Authentication();
        LoginController loginController = new LoginController(loginView, authenticationModel);
        //loginView.resetNameText();
        //loginView.resetPasswordText();
        //loginView.resetEmailText();
        //loginView.setVisible(true);

        // I tried to reset the fields but the error logging in exception kept getting snagged.
        System.out.println("Signed out");
        homeView.dispose();
    };
}
