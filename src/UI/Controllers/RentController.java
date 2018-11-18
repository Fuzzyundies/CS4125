package UI.Controllers;

import Business.Product.Product;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Notifcation;
import Business.Discount.FirstOrder;
import Business.Discount.TwelveOff;
import Business.Discount.Discount;
import Business.Discount.MonthlyDiscount;
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

                /*Assumption: Order just processed is > 200 euro (300). They have a monthly discount rate based on their subscription 
                (Condition 1) It is their first order
                (Condition 2) They have spent >= 200 euro for 12.5% off -> totals in 25% off discount for this order*/
                Discount monthlyTwentyFiveOffFirstOrder = new FirstOrder(new TwelveOff(new MonthlyDiscount()));
                double discountTotal = monthlyTwentyFiveOffFirstOrder.applyDiscount();
                double discountCalculator = 100 - discountTotal;
                double productPriceAfterDiscount = ((discountCalculator * p.getPrice()) / 100);
                System.out.println("Was " + p.getPrice() + " and with a discount of " + discountTotal + ", it is now: " + productPriceAfterDiscount);

                p.setPrice(productPriceAfterDiscount); //set the new price of the product for the user
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
