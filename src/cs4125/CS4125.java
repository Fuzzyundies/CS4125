package cs4125;

import Business.BusinessManagement.Authentication;
import Business.User.Customer;
import UI.Controllers.LoginController;
import UI.UserInterfaces.LoginView;

public class CS4125 
{
    public static Customer loggedInUser;

    public static void main(String[] args) {
        login();
    }

    private static void login() {
        new LoginController(new LoginView(), new Authentication());
    }
}
