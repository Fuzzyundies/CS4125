/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;


import Business.Product.Category;
import DatabaseManagement.CategoriesDAO;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentOutView extends JFrame
{
    // -------- Rent Out View -----------
    JButton newRentOutBtn;
    JButton viewProductsBtn;
    JButton backBtn;
    
    // ----------------------------------
    
    private Category[] categories;
    
    private JPanel panel;
    private JTextField productNameText;
    private JTextField description;
    private JTextField price;

    private JComboBox category;
    
    private JButton add;
    private JButton cancel;
    
    public RentOutView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        this.add(panel);
        displayRentOutView();
        //displayRentOutNewProduct();
        //this.setVisible(true);
    }
    
    public void displayRentOutView()
    {
        System.out.println("Displaying rent out view...");
        
        this.setBounds(450, 250, 400, 200);
        
        panel.removeAll();
        
        newRentOutBtn = new JButton("Rent out a new product");
        viewProductsBtn = new JButton("View Products up for rent");
        backBtn = new JButton("Back");
        
        
        panel.setLayout(new GridLayout(3, 1));
        panel.add(newRentOutBtn);
        panel.add(viewProductsBtn);
        panel.add(backBtn);
        
        panel.revalidate();
        panel.repaint();
        
        this.setVisible(true);
        this.setTitle("Rent out");
    }
    
    public void displayRentOutNewProduct()
    {
        try{
            categories = CategoriesDAO.getCategories();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        this.setBounds(500, 250, 300, 300);
        
        //label.setHorizontalAlignment(JLabel.CENTER);
        //label.setVerticalAlignment(JLabel.CENTER);
        
        panel.removeAll();
        
        productNameText = new JTextField();
        
        description = new JTextField();
        
        category = new JComboBox(categories);
        category.setEditable(false);
        
        price = new JTextField();
        
        add = new JButton("Add");
        cancel = new JButton("Cancel");
        
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.add(new JLabel("Product name:"));
        panel.add(productNameText);
        panel.add(new JLabel("Description:"));
        panel.add(description);
        panel.add(new JLabel("Category:"));
        panel.add(category);
        panel.add(new JLabel("Price:"));
        panel.add(price);
        panel.add(add);
        panel.add(cancel);
        
        panel.revalidate();
        panel.repaint();
        
        this.setVisible(true);
        this.setTitle("RentOutView");
    }
    
    
    public String getNewProductName()
    {
        return productNameText.getText();
    }
    
    public String getNewProductDescription()
    {
        return description.getText();
    }
    
    public String getNewProductPrice()
    {
        return price.getText();
    }
    
    /*
    public Category getName()
    {
        return category;    //I dunno yet
    }
    */
    
    
    public void addAddNewProductBtnListener(ActionListener listener)
    {
        newRentOutBtn.addActionListener(listener);
    }
    
    public void viewProductsBtnListener(ActionListener listener)
    {
        viewProductsBtn.addActionListener(listener);
    }
    
    public void backBtnListener(ActionListener listener)
    {
        backBtn.addActionListener(listener);
    }
    
    
    public void addAddListener(ActionListener listenerForAdd)
    {
        add.addActionListener(listenerForAdd);
    }
    
    public void cancelAddListener(ActionListener listenerForCancel)
    {
        cancel.addActionListener(listenerForCancel);
        System.out.println("In rent out view cancel add listener");
    }
}
