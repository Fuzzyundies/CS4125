package UI.UserInterfaces;

import Business.Product.Category;
import Business.Product.Product;
import DatabaseManagement.CategoriesDAO;
import DatabaseManagement.ProductDAO;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RentView extends JFrame {

    private JPanel panel;
    
    // ---------- Category List View ------------------
    private JButton select;
    private JButton back;
    private JComboBox categoryList;
    private Category[] categories;
    // ------------------------------------------------
    
    // ----------- Product List View ------------------
    private JList listOfProducts;
    // ------------------------------------------------

    public RentView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
        displayRentView();
    }

    public void displayRentView() 
    {
        try {
            categories = CategoriesDAO.getCategories();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        this.setBounds(450, 250, 270, 100);
        
        panel.removeAll();
        
        categoryList = new JComboBox(categories);
        select = new JButton("Select");
        back = new JButton("Back");

        panel.setLayout(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Categories:"));
        panel.add(categoryList);
        panel.add(select);
        panel.add(back);
        
        panel.revalidate();
        panel.repaint();
        
        pack();
        this.setVisible(true);
        this.setTitle("Categories");
    }
    
    /*
    public void displayBrowseCategories()
    {
        
    }
    */
    
    public void displayListOfProducts(int cID)
    {
        System.out.println("Displaying list of products...");
        Product [] products = ProductDAO.getListProducts(cID);
        
        this.setBounds(450, 250, 270, 100);
        
        select = new JButton("Select");
        back = new JButton("Back");
        listOfProducts = new JList(products);
        
        panel.removeAll();
        
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JScrollPane(listOfProducts));
        panel.add(new JLabel());
        panel.add(back);
        panel.add(select);
        
        panel.revalidate();
        panel.repaint();
    }
    
    public void displayProductDetails()
    {
        
    }
    
    public void displayConfirmRental()
    {
        
    }
    
    public void displayRentalConfirmation()
    {
        
    }

    public void addSelectBtnListener(ActionListener listener) {
        select.addActionListener(listener);
    }

    public void addBackBtnListner(ActionListener listener) {
        back.addActionListener(listener);
    }
    
    public void addBackToCatBtnListener(ActionListener listener)
    {
        back.addActionListener(listener);
    }
    
    public void addSelectProductBtnListener(ActionListener listener)
    {
        select.addActionListener(listener);
    }

    public Category getChosenCategory() {
        return (Category) categoryList.getSelectedItem();
    }
}
