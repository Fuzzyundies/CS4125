/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import Business.BusinessManagement.Authentication;
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
                    // User found, goto HOME
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
        }
        
    }
}
