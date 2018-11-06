package UI.UserInterfaces;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RentView extends JFrame {

    private JPanel panel;
    private JButton select;
    private JButton back;
    private JComboBox categoryList;
    //private List<Category> categories;

    private final String[] categories = {"Computers & Networking", "Cameras & Photography",
        "Cars, Motorcycles & Vehicles", "Electronics", "Entertainment", "Gaming", "Garden & DIY",
        "Home & Furniture", "Office", "Sports & Leisure"};

    public RentView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
        displayRentView();
    }

    public void displayRentView() {
        this.setBounds(50, 50, 250, 100);
        categoryList = new JComboBox(categories);
        panel.add(categoryList);
        select = new JButton("Select");
        back = new JButton("Back");
        panel.add(select);
        panel.add(back);
        panel.revalidate();
        this.setVisible(true);
        this.setTitle("Categories");
    }

    public void addSelectBtnListener(ActionListener listner) {
        select.addActionListener(listner);
    }

    public void addBackBtnListner(ActionListener listener) {
        back.addActionListener(listener);
    }

    public /*Category*/ String getChosenCategory() {
        return categoryList.getSelectedItem().toString();
    }
}
