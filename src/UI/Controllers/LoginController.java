/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import Business.BusinessManagement.Authentication;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Benjamin Grimes
 */
public class LoginController 
{
    private LoginView loginView;
    private Authentication authenticationModel;
    
    public LoginController(LoginView view, Authentication model)
    {
        this.loginView = view;
        this.authenticationModel = model;
        view.addLoginBtnListener(new LoginBtnListener());
        view.addSignUpBtnListener(new SignUpBtnListener());
    }
    
    private void backToLogin()
    {
        loginView.displayLoginView();
        loginView.addLoginBtnListener(new LoginBtnListener());
        loginView.addSignUpBtnListener(new SignUpBtnListener());
    }
    
    class LoginBtnListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String username = "";
            String password = "";
            
            try
            {
                username = loginView.getName();
                password = loginView.getPassword();
                
                authenticationModel.checkForUser(username, password);
                int result = authenticationModel.getResult();
                
                if(result <= 0)
                {
                    loginView.displayErrorMessage("User not found");
                }
                else
                {
                    // User found, 
                    // TODO goto HOME

                    HomeView homeView = new HomeView();  
                    HomeController homeController = new HomeController(homeView);
                    
                    loginView.setVisible(false);
                    System.out.println("User found...\nID:" + result);
                }
            }
            catch(Exception ex)
            {
                loginView.displayErrorMessage("Error loggin in");
            }
        }
    }
    
    class SignUpBtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            loginView.displaySignUpView();
            loginView.addCancelBtnListener(new CancelBtnListener());
            loginView.addConfirmBtnListener(new ConfirmBtnListner());
        }
    }
    
    class CancelBtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Back to login");
            backToLogin();
        }
        
    }
    
    class ConfirmBtnListner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String username = loginView.getName();
            String email = loginView.getEmail();
            String password = loginView.getPassword();
            
            boolean inUse = authenticationModel.checkIfEmailInUse(email);
            
            if(inUse)
            {
                loginView.displayErrorMessage("Email is in use");
            }
            else
            {
                inUse = authenticationModel.checkIfUsernameInUse(username);
                if(inUse)
                {
                    loginView.displayErrorMessage("Username is in use");
                }
                else
                {
                    // Create new customer
                    authenticationModel.addNewUser(username, email, password);
                    backToLogin();
                }
            }
        }
    }
    
    
}
