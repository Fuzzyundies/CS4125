/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllers;

import Business.Product.Category;
import Business.Product.Product;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentOutView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentOutController {

    private RentOutView view;
    private final HomeView homeView;

    public RentOutController(RentOutView view, HomeView homeView) //addAuthentication model as third arg
    {
        this.view = view;
        this.homeView = homeView;
        view.addAddNewProductBtnListener(addNewProductActionListener);
        view.viewProductsBtnListener(viewProductsActionListener);
        view.backBtnListener(backToHomeActionListener);
    }

    private void backToHome() {
        homeView.setVisible(true);
        view.dispose();
    }

    private ActionListener AddAddActionListener = (ActionEvent e) -> {
        System.out.println("Add pressed...");
        // Added Product to DB
    };

    private ActionListener CancelActionListener = new ActionListener() {
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
            view.displayRentOutNewProduct(Category.getCategories());
            view.addAddListener(AddAddActionListener);
            view.cancelAddListener(CancelActionListener);
        }
    };

    private ActionListener selectProducListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Display product details...");
            Product p = view.getSelectedProduct();
            if (p != null) {
                view.displayProductDetails(p);
                view.backBtnListener(backToProductsActionListener);
                view.stopLeasingOutBtnListener(stopLeasingOutProductActionListener);
            }
        }
    };

    private ActionListener viewProductsActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("View products ive up for lease...");
            view.displayProductsUpForRent(cs4125.CS4125.loggedInUser.getLeasedProducts());
            view.backBtnListener(CancelActionListener);
            view.selectProductBtnListener(selectProducListener);
        }
    };

    private ActionListener backToHomeActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backToHome();
        }
    };

    private ActionListener backToProductsActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("View products ive up for lease...");
            view.displayProductsUpForRent(cs4125.CS4125.loggedInUser.getLeasedProducts());
            view.backBtnListener(CancelActionListener);
            view.selectProductBtnListener(selectProducListener);
        }
    };

    private ActionListener stopLeasingOutProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Stop Leasing out product...");
        }
    };
}
