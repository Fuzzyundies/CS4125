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
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.ProfileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController {

    private ProfileView profileView;
    private HomeView homeView;

    public ProfileController(ProfileView profileView, HomeView homeView) {
        this.profileView = profileView;
        this.homeView = homeView;
        profileView.addSubscriptionButtonListener(renewSubscriptionListener);
        profileView.addHistBtnListener(viewHistoryListener);
        profileView.addEditBtnListener(editProfileListener);
        profileView.addHomeBtnListener(backHomeListener);
    }

    private final ActionListener renewSubscriptionListener = (ActionEvent e) -> {
    };

    private final ActionListener viewHistoryListener = (ActionEvent e) -> {
    };

    private final ActionListener backToProfileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileView.displayProfile();
            profileView.addEditBtnListener(editProfileListener);
            profileView.addHomeBtnListener(backHomeListener);
        }
    };

    private ActionListener editProfileListener = (ActionEvent e) -> {
        profileView.createEditProfileWindow();
        profileView.addBackBtnListner(backToProfileListener);
        //save..
    };

    private final ActionListener backHomeListener = (ActionEvent e) -> {
        backToHome();
    };

    private void backToHome() {
        homeView.setVisible(true);
        profileView.dispose();
    }

}
