package cs4125;

import Business.BusinessManagement.Authentication;
import UI.Controllers.LoginController;
import UI.UserInterfaces.LoginView;

public class CS4125 {

    public static int userID;
    public static String username;
    public static String email;

    public static void main(String[] args) {
        login();
    }

    private static void login() {
        new LoginController(new LoginView(), new Authentication());
    }
}
