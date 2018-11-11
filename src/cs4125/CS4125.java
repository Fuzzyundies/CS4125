package cs4125;

import Business.BusinessManagement.Authentication;
import UI.Controllers.LoginController;
import UI.UserInterfaces.LoginView;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;

public class CS4125 {

    public static void main(String[] args) 
    {
        // TODO code application logic here
        login();
    }
    
    private static void login()
    {
        //Temp login: username = username1, password = password1
        //RentOutView view = new RentOutView();
        //HomeView view = new HomeView();
        LoginView view = new LoginView();
        Authentication model = new Authentication();
        LoginController controller = new LoginController(view, model);
    }

}
