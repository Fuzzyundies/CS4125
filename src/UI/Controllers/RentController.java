package UI.Controllers;

import Business.Product.Product;

import UI.UserInterfaces.HomeView;
import UI.UserInterfaces.RentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Benjamin Grimes
 */
public class RentController {

    private RentView view;
    private HomeView homeView;

    public RentController(RentView view, HomeView homeView) {
        this.view = view;
        this.homeView = homeView;
        view.addSelectBtnListener(selectActionListener);
        view.addBackBtnListner(backActionListener);
    }

    private ActionListener selectActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println(view.getChosenCategory().getName());
            view.displayListOfProducts(view.getChosenCategory().getId());
            view.addBackBtnListner(backToCategoryActionListioner);
            view.addSelectBtnListener(selectProductActionListener);

        }
    };
    
    private ActionListener backActionListener = (ActionEvent e) -> {
        homeView.setVisible(true);
        view.dispose();
    };

    private ActionListener backToCategoryActionListioner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayRentView();
            view.addSelectBtnListener(selectActionListener);
            view.addBackBtnListner(backActionListener);

        }
    };

    private ActionListener selectProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = view.getSelectedProduct();
            if (p != null) {
                view.displayProductDetails(p);
                view.addBackBtnListner(backToProductListActionListener);
                view.addRentProductBtnListener(rentProductActionListener);
            }
        }
    };

    private ActionListener backToProductListActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayListOfProducts(view.getChosenCategory().getId());
            view.addBackBtnListner(backToCategoryActionListioner);
            view.addSelectBtnListener(selectProductActionListener);
        }
    };

    private ActionListener rentProductActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Rent product...");
            view.displayRentProduct(view.getSelectedProduct());
            view.addSelectBtnListener(confirmRentalActionListener);
            view.addBackBtnListner(backToProductDetailsActionListener);
        }
    };

    private ActionListener backToProductDetailsActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.displayProductDetails(view.getSelectedProduct());
            view.addBackBtnListner(backToProductListActionListener);
            view.addRentProductBtnListener(rentProductActionListener);
        }
    };

    private ActionListener confirmRentalActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Confirm rental...");
        }
    };
}
