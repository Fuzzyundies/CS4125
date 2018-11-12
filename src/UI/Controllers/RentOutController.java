/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;
import UI.UserInterfaces.RentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RentOutController {
    
    private RentOutView view;
    private HomeView homeView;
    
    public RentOutController(RentOutView view, HomeView homeView)  //addAuthentication model as third arg
    {
        this.view = view;
        //add auth model
        
        view.addAddListener(AddAddActionListener);
        view.cancelAddListener(CancelAddActionListener);
    }
    
    private ActionListener AddAddActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
           
        }
    };
    
    private ActionListener CancelAddActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           //Broken for now
            homeView.setVisible(true);
            System.out.println("cancel been pressed");
           // view.dispose();
        }
    };
    
    
    
    
    
}
