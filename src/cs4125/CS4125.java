package cs4125;

import Business.BusinessManagement.Authentication;
import UI.Controllers.LoginController;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.HomeView;

public class CS4125 {

    public static void main(String[] args) 
    {
        // TODO code application logic here
        login();
    }
    
    private static void login()
    {
        // Temp login: username = benjamin, password = benjaminpw
        HomeView view = new HomeView();
        //Authentication model = new Authentication();
        //LoginController controller = new LoginController(view, model);
    }

}
