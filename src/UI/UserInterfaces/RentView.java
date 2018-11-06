package UI.UserInterfaces;

import Business.Product.Category;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RentView extends JFrame {

    private JPanel panel;
    // private List<Category> categories;

    private final String[] categories = {"Computers & Networking", "Cameras & Photography",
        "Cars, Motorcycles & Vehicles", "Electronics", "Entertainment", "Gaming", "Garden & DIY",
        "Home & Furniture", "Office", "Sports & Leisure"};

    public RentView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        //categories = getCategoriesList();
        add(panel);
        displayRentView();
    }

    public void displayRentView() {
        this.setBounds(50, 50, 250, 100);
        JComboBox categoryList = new JComboBox(categories);
        panel.add(categoryList);
        JButton select = new JButton("Select");
        JButton back = new JButton("Back");
        panel.add(select);
        panel.add(back);
        panel.revalidate();
        this.setVisible(true);
        this.setTitle("Categories");
    }

    public Category getChosenCategory() {
        return null;
    }
}
