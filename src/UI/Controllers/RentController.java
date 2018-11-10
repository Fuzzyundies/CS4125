package UI.Controllers;

import UI.UserInterfaces.RentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Benjamin Grimes
 */
public class RentController {

    private RentView view;

    public RentController(RentView view) {
        this.view = view;
        view.addSelectBtnListener(seleActionListener);
        view.addBackBtnListner(backActionListener);
    }

    private ActionListener seleActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              System.out.println(view.getChosenCategory().getName());
        }
    };

    private ActionListener backActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
    };

}
