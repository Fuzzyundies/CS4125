package UI.UserInterfaces;

import Business.Product.Category;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RentView extends JFrame {

    private JPanel panel;
    private JButton select;
    private JButton back;
    private JComboBox categoryList;
    private Category[] categories = {new Category("1", "Computers & Networking"), new Category("2", "Cameras & Photography")};

    public RentView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
        displayRentView();
    }

    public void displayRentView() {
        this.setBounds(450, 250, 270, 100);
        categoryList = new JComboBox(categories);
        select = new JButton("Select");
        back = new JButton("Back");

        panel.setLayout(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Categories:"));
        panel.add(categoryList);
        panel.add(select);
        panel.add(back);
        panel.revalidate();
        pack();
        this.setVisible(true);
        this.setTitle("Categories");
    }

    public void addSelectBtnListener(ActionListener listener) {
        select.addActionListener(listener);
    }

    public void addBackBtnListner(ActionListener listener) {
        back.addActionListener(listener);
    }

    public Category getChosenCategory() {
        return (Category) categoryList.getSelectedItem();
    }
}
