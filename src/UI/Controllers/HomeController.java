/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.ProfileView;
import UI.UserInterfaces.RentOutView;
import UI.UserInterfaces.RentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Benjamin Grimes
 */
public class HomeController {

    private HomeView homeView;

    public HomeController(HomeView view) {
        this.homeView = view;

        view.addRentListener(rentActionListener);
        view.addRentOutListener(rentOutActionListener);
        view.addViewProfileListener(viewProfileActionListener);
        view.addSignOutListener(signOutActionListener);
    }

    private final ActionListener rentActionListener = (ActionEvent e) -> {
        //Go to RentView
        RentView rentView = new RentView();
        RentController rentViewController = new RentController(rentView, homeView);
        homeView.setVisible(false);
    };

    private final ActionListener rentOutActionListener = (ActionEvent e) -> {
        //Go to RentOutView ----------RentoutController needs to be done
        RentOutView rentOutView = new RentOutView();
        RentOutController rentOutController = new RentOutController(rentOutView, homeView);
        homeView.setVisible(false);
    };

    private final ActionListener viewProfileActionListener = (ActionEvent e) -> {
        String temp = "temp";
        Double temp2 = 2.0;
        ProfileView profileView = new ProfileView(temp, temp2);
        ProfileController profileController = new ProfileController(profileView, homeView);
        homeView.setVisible(false);
    };

    private final ActionListener signOutActionListener = (ActionEvent e) -> {
        //To do Sign out functionality
    };
}
