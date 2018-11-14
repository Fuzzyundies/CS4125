/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;


import Business.Product.Category;
import Business.Product.Product;
import DatabaseManagement.CategoriesDAO;
import DatabaseManagement.ProductDAO;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RentOutView extends JFrame
{
    
    JButton backBtn;
    // -------- Rent Out View -----------
    JButton newRentOutBtn;
    JButton viewProductsBtn;
    // ----------------------------------
    
    // --------- Rent out new product -----
    private Category[] categories;
    private JPanel panel;
    private JTextField productNameText;
    private JTextField description;
    private JTextField price;
    private JComboBox category;
    private JButton add;
    private JButton cancel;
    // -------------------------------------
    
    // ---- List of products up for rent ---
    private JList listOfProducts;
    private JButton selectBtn;
    // -------------------------------------
    
    
    // ----- Product details ----------------
    JButton stopLeasingOutBtn;
    
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
    
    public void displayProductsUpForRent()
    {
        this.setBounds(500, 250, 300, 300);
        
        // TODO get list of products where:
        // ownerID = loggedInUserID
        Product [] products = ProductDAO.getListProducts(1); // Temp value
        
        
        
        panel.removeAll();
        
        listOfProducts = new JList(products);
        backBtn = new JButton("Back");
        selectBtn = new JButton("Select Product");
        
        panel.setLayout(new GridLayout(2, 1));
        panel.add(new JScrollPane(listOfProducts));
        
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new GridLayout(1, 2));
        btnContainer.add(backBtn);
        btnContainer.add(selectBtn);
        
        panel.add(btnContainer);
        
        panel.revalidate();
        panel.repaint();
        
        this.setTitle("List of products up for rent");
    }
    
    public void displayProductDetails(Product p)
    {
        System.out.println("Displaying product details...");
        this.setBounds(450, 250, 400, 200);
        
        stopLeasingOutBtn = new JButton("Stop Leasing Product");
        backBtn = new JButton("Back");
        
        String available;
        if(p.getIs_available() >= 1)
            available = "Available for rental";
        else
            available = "Currently being rented";
        
        panel.removeAll();
        
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Product:"));
        panel.add(new JLabel(p.getName()));
        panel.add(new JLabel("Description:"));
        panel.add(new JLabel(p.getDescription()));
        panel.add(new JLabel("Price:"));
        panel.add(new JLabel(""+p.getPrice()));
        panel.add(new JLabel("Rating:"));
        panel.add(new JLabel(""+p.getRating()));
        panel.add(new JLabel("Available:"));
        panel.add(new JLabel(available));
        panel.add(backBtn);
        panel.add(stopLeasingOutBtn);
        
        panel.revalidate();
        panel.repaint();
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
    
    public Product getSelectedProduct()
    {
        Product tmp = (Product) listOfProducts.getSelectedValue();
        return tmp;
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
    
    public void selectProductBtnListener(ActionListener listener)
    {
        selectBtn.addActionListener(listener);
    }
    
    public void stopLeasingOutBtnListener(ActionListener listener)
    {
        stopLeasingOutBtn.addActionListener(listener);
    }
}
