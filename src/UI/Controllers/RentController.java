package UI.Controllers;

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
        }
    };

    private ActionListener backActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
           homeView.setVisible(true);
           view.dispose();
        }
    };

}
