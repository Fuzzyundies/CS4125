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

    private HomeView view;

    public HomeController(HomeView view) {
        this.view = view;

        view.addRentListener(RentActionListener);
        view.addRentOutListener(RentOutActionListener);
        view.addViewProfileListener(AddViewProfileActionListener);
        view.addSignOutListener(AddSignOutActionListener);
    }

    private ActionListener RentActionListener = (ActionEvent e) -> {
        //Go to RentView
        RentView rentView = new RentView();
        RentController rentViewController = new RentController(rentView, view);
        view.setVisible(false);
    };

    private ActionListener RentOutActionListener = (ActionEvent e)
            -> {
        //Go to RentOutView ----------RentoutController needs to be done
        RentOutView rentOutView = new RentOutView();
        RentOutController rentOutController = new RentOutController(rentOutView, view);
        view.setVisible(false);
    };

    private ActionListener AddViewProfileActionListener = (ActionEvent e)
            -> {
        //Go to ViewProfile
        String temp = "temp";
        Double temp2 = 2.0;
        ProfileView profileView = new ProfileView(temp, temp2);
    };

    private ActionListener AddSignOutActionListener = (ActionEvent e) -> {
        //To do Sign out functionality
    };
}
