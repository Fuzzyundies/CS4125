package cs4125;

import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Authentication;
import UI.Controllers.HomeController;
import UI.Controllers.LoginController;
import UI.Controllers.RentController;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;
import UI.UserInterfaces.ProfileView;
import UI.Controllers.ProfileController;

public class CS4125 
{
    private static RentOutView rentOutView;
    private static HomeView homeView;
    private static LoginView loginView;
    private static Authentication model;
    private static LoginController controller;
    private static ProfileView profileView;
    private static RentView rentView;
    private static double rating;
    private static String user;
            
    public static void main(String[] args) 
    {
        int scene = 1;
        panelCreator();
        sceneManager(scene);
        //login();
        
    }
    
    private static void panelCreator()
    {
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
    
    public static void sceneManager(int scene)
    {   
        switch (scene)
        {
            case 0: System.exit(0); break;
            case 1: loginView.setVisible(true); break;
            case 2: homeView.setVisible(true); break;
            case 3: profileView.setVisible(true); break;
            case 4: rentOutView.setVisible(true); break;
            case 5: rentView.setVisible(true); break;
        }
    }        
    
    public static void setUser(String user)
    {
        CS4125.user = user;
    }
    
    public static void setRating(double rating)
    {
        CS4125.rating = rating;
    }
    /*
    private static void login()
    {
        //Temp login: username = username1, password = password1
        RentOutView view = new RentOutView();
        HomeView view = new HomeView();
        LoginView view = new LoginView();
        Authentication model = new Authentication();
        LoginController controller = new LoginController(view, model);
    }

    */
}
