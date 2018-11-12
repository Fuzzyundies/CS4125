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
    private LoginView view;
    private Authentication model;
    
    public LoginController(LoginView view, Authentication model)
    {
        this.view = view;
        this.model = model;
        
        view.addLoginBtnListener(new LoginBtnListener());
        view.addSignUpBtnListener(new SignUpBtnListener());
        
    }
    
    private void backToLogin()
    {
        view.displayLoginView();
        view.addLoginBtnListener(new LoginBtnListener());
        view.addSignUpBtnListener(new SignUpBtnListener());
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
                username = view.getName();
                password = view.getPassword();
                
                model.checkForUser(username, password);
                int result = model.getResult();
                
                if(result <= 0)
                {
                    view.displayErrorMessage("User not found");
                }
                else
                {
                    // User found, 
                    // TODO goto HOME
                    HomeView view = new HomeView();   
                    System.out.println("User found...\nID:" + result);
                }
            }
            catch(Exception ex)
            {
                view.displayErrorMessage("Error loggin in");
            }
        }
    }
    
    class SignUpBtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            view.displaySignUpView();
            view.addCancelBtnListener(new CancelBtnListener());
            view.addConfirmBtnListener(new ConfirmBtnListner());
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
            String username = view.getName();
            String email = view.getEmail();
            String password = view.getPassword();
            
            boolean inUse = model.checkIfEmailInUse(email);
            
            if(inUse)
            {
                view.displayErrorMessage("Email is in use");
            }
            else
            {
                inUse = model.checkIfUsernameInUse(username);
                if(inUse)
                {
                    view.displayErrorMessage("Username is in use");
                }
                else
                {
                    // Create new customer
                    model.addNewUser(username, email, password);
                    backToLogin();
                }
            }
        }
    }
    
    
}
