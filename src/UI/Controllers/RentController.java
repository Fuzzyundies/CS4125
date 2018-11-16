package UI.Controllers;

import Business.Product.Product;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Notifcation;
import Business.User.Customer;
import Business.User.UserFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Benjamin Grimes
 */
public class RentController {

    private RentView rentView;
    private HomeView homeView;

    public RentController(RentView view, HomeView homeView) {
        this.rentView = view;
        this.homeView = homeView;
        rentView.addSelectBtnListener(selectActionListener);
        rentView.addBackBtnListner(backActionListener);
    }

    private ActionListener selectActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(rentView.getChosenCategory().getName());
            rentView.displayListOfProducts(rentView.getChosenCategory().getId());
            rentView.addBackBtnListner(backToCategoryActionListioner);
            rentView.addSelectBtnListener(selectProductActionListener);
        }
    };

    private ActionListener backActionListener = (ActionEvent e) -> {
        homeView.setVisible(true);
        rentView.dispose();
    };

    private ActionListener backToCategoryActionListioner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            rentView.displayRentView();
            rentView.addSelectBtnListener(selectActionListener);
            rentView.addBackBtnListner(backActionListener);
        }
    };

    private ActionListener selectProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = rentView.getSelectedProduct();
            if (p != null) {
                rentView.displayProductDetails(p);
                rentView.addBackBtnListner(backToProductListActionListener);
                if (p.getIs_available() >= 1) {
                    rentView.addRentProductBtnListener(rentProductActionListener);
                } else {
                    rentView.registerObserverListener(registerObserverActionListener);
                }
            }
        }
    };

    private ActionListener registerObserverActionListener = (ActionEvent e) -> {
        Product p = rentView.getSelectedProduct();
        if (p != null) {
            System.out.println("\n\nAdding you to the queue");
            UserFactory userFactory = new UserFactory();
            Notifcation notification = new Notifcation();
            Customer customer = (Customer) userFactory.getUser("C");
            notification.registerObserver(customer);

            //Some time later - product is now available - leaser makes it available via their list of products
            //testing
            p.setIs_available(1);
            notification.notify(p);
            notification.unregisterObserver(customer);
        }
    };

    private ActionListener backToProductListActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            rentView.displayListOfProducts(rentView.getChosenCategory().getId());
            rentView.addBackBtnListner(backToCategoryActionListioner);
            rentView.addSelectBtnListener(selectProductActionListener);
        }
    };

    private ActionListener rentProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Rent product...");
            rentView.displayRentProduct(rentView.getSelectedProduct());
            rentView.addSelectBtnListener(confirmRentalActionListener);
            rentView.addBackBtnListner(backToProductDetailsActionListener);
        }
    };

    private ActionListener backToProductDetailsActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            rentView.displayProductDetails(rentView.getSelectedProduct());
            rentView.addBackBtnListner(backToProductListActionListener);
            rentView.addRentProductBtnListener(rentProductActionListener);
        }
    };

    private ActionListener confirmRentalActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Confirm rental...");
        }
    };
}
