/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RentOutController {
    
    private RentOutView view;
    private HomeView homeView;
    
    public RentOutController(RentOutView view, HomeView homeView)  //addAuthentication model as third arg
    {
        this.view = view;
        this.homeView = homeView;
        
        view.addAddNewProductBtnListener(addNewProductActionListener);
        view.viewProductsBtnListener(viewProductsActionListener);
        view.backBtnListener(backToHomeActionListener);
        
        /*
        view.addAddListener(AddAddActionListener);
        view.cancelAddListener(CancelAddActionListener);
        */
    }
    
    
    
    private void backToHome() 
    {
        homeView.setVisible(true);
        view.dispose();
    }
    
    private ActionListener AddAddActionListener = (ActionEvent e) -> {
        System.out.println("Add pressed...");
        // Added Product to DB
    };
    
    private ActionListener CancelAddActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayRentOutView();
            view.addAddNewProductBtnListener(addNewProductActionListener);
            view.viewProductsBtnListener(viewProductsActionListener);
            view.backBtnListener(backToHomeActionListener);
        }
    };
    
    private ActionListener addNewProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Goto add new product...");
            view.displayRentOutNewProduct();
            view.addAddListener(AddAddActionListener);
            view.cancelAddListener(CancelAddActionListener);
        }
    };
    
    private ActionListener viewProductsActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("View products ive up for lease...");
        }
    };
    
    private ActionListener backToHomeActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Back to home...");
            backToHome();
        }
    };
    
}
