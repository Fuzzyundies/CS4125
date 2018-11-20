package cs4125;

import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Authentication;
import Business.Product.Product;
import UI.Controllers.LoginController;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;
import UI.UserInterfaces.ProfileView;

public class CS4125 {

    public static int userID;
    public static String username;
    public static String email;

    private static RentOutView rentOutView;
    private static HomeView homeView;
    private static LoginView loginView;
    private static Authentication model;
    private static LoginController controller;
    private static ProfileView profileView;
    private static RentView rentView;
    private static double rating;
    private static String user;

    private static final int QUIT = 0;
    private static final int LOGIN_VIEW = 1;
    private static final int HOME_VIEW = 2;
    private static final int PROFILE_VIEW = 3;
    private static final int RENT_OUT_VIEW = 4;
    private static final int RENT_VIEW = 5;

    public static void main(String[] args) {
        int scene = 1;
        //panelCreator();
        //sceneManager(scene);
        Product p = new Product(1, "BBQ", 2, 10, 19.99, 5, "Beautiful BBQ", 1);
        System.out.println(p.showStatus());
        p.nextState();
        System.out.println(p.showStatus());
        p.nextState();
        System.out.println(p.showStatus());
        p.nextState();
        System.out.println(p.showStatus());
        p.nextState();

        login();

    }

    private static void panelCreator() {
        rentOutView = new RentOutView();
        rentOutView.setVisible(false);
        homeView = new HomeView();
        homeView.setVisible(false);
        loginView = new LoginView();
        loginView.setVisible(false);
        profileView = new ProfileView(user, rating);
        profileView.setVisible(false);
        rentView = new RentView();
        rentView.setVisible(false);
        model = new Authentication();
        controller = new LoginController(loginView, model);
    }

    public static void sceneManager(int scene) {
        switch (scene) {
            case QUIT:
                System.exit(0);
                break;
            case LOGIN_VIEW:
                loginView.setVisible(true);
                break;
            case HOME_VIEW:
                homeView.setVisible(true);
                break;
            case PROFILE_VIEW:
                profileView.setVisible(true);
                break;
            case RENT_OUT_VIEW:
                rentOutView.setVisible(true);
                break;
            case RENT_VIEW:
                rentView.setVisible(true);
                break;
        }
    }

    public static void setUser(String user) {
        CS4125.user = user;
    }

    public static void setRating(double rating) {
        CS4125.rating = rating;
    }

    private static void login() {
        //Temp login: username = username1, password = password1
        //RentOutView rentOut = new RentOutView();

        //HomeView home = new HomeView();
        //RentOutController rentOutController = new RentOutController(rentOut, home);
        LoginView loginView = new LoginView();
        Authentication authenticationModel = new Authentication();
        LoginController loginController = new LoginController(loginView, authenticationModel);
    }

}
