package cs4125;

import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Authentication;
import UI.Controllers.HomeController;
import UI.Controllers.LoginController;
import UI.Controllers.RentController;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;

public class CS4125 {

    public static void main(String[] args) {
        login();
    }

    private static void login() {
        // Temp login: username = benjamin, password = benjaminpw
        HomeView home = new HomeView();
        HomeController homeController = new HomeController(home);
        //RentOutView view = new RentOutView();
        //LoginView view = new LoginView();
        //Authentication model = new Authentication();
        //LoginController controller = new LoginController(view, model);
        //LoginView view = new LoginView();
        //Authentication model = new Authentication();
        //LoginController controller = new LoginController(view, model);
        
        //new RentController(new RentView());
    }
}
