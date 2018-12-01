package UI.Controllers;

import Business.Product.Product;

import Business.BusinessManagement.Locker;
import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentView;
import Business.BusinessManagement.Notifcation;
import Business.BusinessManagement.Transaction;
import Business.Discount.FirstOrderDiscount;
import Business.Discount.TwelveDiscount;
import Business.Discount.Discount;
import Business.Discount.MonthlyDiscount;
import Business.Product.Category;
import Business.User.Customer;
import Business.User.UserFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

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
        rentView.displayRentView(Category.getCategories());
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
            rentView.displayRentView(Category.getCategories());
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
                Discount monthlyTwentyFiveOffFirstOrder = new FirstOrderDiscount(new TwelveDiscount(new MonthlyDiscount()));
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
        public void actionPerformed(ActionEvent e) 
        {
            // Generate the locker codes
            int max = 9999;
            int min = 1000;
            Random rand = new Random(System.currentTimeMillis());
            int r_code = rand.nextInt((max-min)+1) + min;
            int l_code = rand.nextInt((max-min)+1) + min;
            while(r_code == l_code){
                System.out.println("In this loop");
                l_code = rand.nextInt((max-min)+1) + min;
            }
            System.out.println(r_code + " " + l_code);
            
            // Get the product selected for rent
            Product selectedProduct = rentView.getSelectedProduct();
            LocalDate today = LocalDate.now();
            LocalDate startDate = today.plus(1, ChronoUnit.DAYS);
            LocalDate endDate = startDate.plus(rentView.getNumberOfDays(), ChronoUnit.DAYS);
            
            System.out.println("Today" + today);
            System.out.println("StartDate: " + startDate);
            System.out.println("End Date: " + endDate);
            
            // Create the new transaction
            double amount = selectedProduct.getPrice() * rentView.getNumberOfDays();
            Transaction newTransaction = new Transaction(LocalDate.now(), amount, cs4125.CS4125.userID, selectedProduct.getId());
            newTransaction.executeTransaction();
            
            int leaserID = newTransaction.getLeaserID();
            
            // Notify the renter and leaser
            Notifcation initialNotifcation = new Notifcation(cs4125.CS4125.userID, leaserID);
            initialNotifcation.setRenterEmail("Rental Confirmation","You've rented " + selectedProduct.getName() + ""
                    + ".\n It will be available for collection tomorrow at depot XXXX.\n "
                    + "Your rental period: " + startDate + " until " + endDate + "\n"+ "Cost: "
                            + amount);
            initialNotifcation.setLeaserEmail("Rental Confirmation","Hello leaser");
            initialNotifcation.sendEmail();
                        
            //Locker l = new Locker(r_code, l_code, newTransaction, date);
            
            // TODO Change the Product state
            //selectedProduct.setState(/*rented*/);
            selectedProduct.setIs_available(0);
            /*
            homeView.setVisible(true);
            rentView.dispose();
            */
        }
    };
}
