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

    // ----------- Product Details View ---------------
    private JButton rent_btn;
    // ------------------------------------------------

    // ----------- Rent Product View ------------------
    // ------------------------------------------------
    public RentView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
        displayRentView();
    }

    public void displayRentView() {
        try {
            categories = CategoriesDAO.getCategories();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.setBounds(450, 250, 400, 200);
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
    
    public void displayListOfProducts(int cID) {
        System.out.println("Displaying list of products...");
        Product[] products = ProductDAO.getListProducts(cID);

        this.setBounds(450, 250, 400, 200);

        select = new JButton("Select");
        back = new JButton("Back");
        listOfProducts = new JList(products);

        panel.removeAll();

        panel.setLayout(new GridLayout(2, 1));
        panel.add(new JScrollPane(listOfProducts));

        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new GridLayout(1, 2));
        btnContainer.add(back);
        btnContainer.add(select);
        panel.add(btnContainer);

        panel.revalidate();
        panel.repaint();
    }

    public void displayProductDetails(Product p) {
        System.out.println("Displaying product details...");
        this.setBounds(450, 250, 400, 200);
        rent_btn = new JButton("Rent Product");
        back = new JButton("Back");

        String available;
        if (p.getIs_available() >= 1) {
            available = "Available for rental";
        } else {
            available = "Currently being rented";
            rent_btn.setText("Notify me");
        }
        panel.removeAll();

        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Product:"));
        panel.add(new JLabel(p.getName()));
        panel.add(new JLabel("Description:"));
        panel.add(new JLabel(p.getDescription()));
        panel.add(new JLabel("Price:"));
        panel.add(new JLabel("€" + p.getPrice()));
        panel.add(new JLabel("Rating:"));
        panel.add(new JLabel("" + p.getRating()));
        panel.add(new JLabel("Available:"));
        panel.add(new JLabel(available));
        panel.add(back);
        panel.add(rent_btn);

        panel.revalidate();
        panel.repaint();
    }

    public void displayRentProduct(Product p) {
        System.out.println("Displaying confirm rental...");
        select = new JButton("Confirm rental");
        back = new JButton("Back");

        this.setBounds(450, 250, 400, 200);

        panel.removeAll();

        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Product:"));
        panel.add(new JLabel(p.getName()));
        panel.add(new JLabel("TODO ADD TRANSCTION FIELDS"));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Collection Depot:"));
        panel.add(new JLabel("TODO get depot location"));

        panel.add(new JLabel("Rental Period:"));
        JPanel period_panel = new JPanel();
        GridLayout period_grid = new GridLayout(1, 2);
        period_panel.setLayout(period_grid);

        JComboBox fromDatesComboBox = new JComboBox();
        JComboBox toDatesComboBox = new JComboBox();
        period_panel.add(fromDatesComboBox);
        period_panel.add(toDatesComboBox);
        panel.add(period_panel);

        panel.add(back);
        panel.add(select);

        panel.revalidate();
        panel.repaint();
    }

    public void displayRentalConfirmation() {
        System.out.println("Displaying rental confirmation...");
    }

    public void addSelectBtnListener(ActionListener listener) {
        select.addActionListener(listener);
    }

    public void addBackBtnListner(ActionListener listener) {
        back.addActionListener(listener);
    }

    public void addRentProductBtnListener(ActionListener listener) {
        rent_btn.addActionListener(listener);
    }

    public Category getChosenCategory() {
        return (Category) categoryList.getSelectedItem();
    }

    public Product getSelectedProduct() {
        Product tmp = (Product) listOfProducts.getSelectedValue();
        return tmp;
    }
    
    public void registerObserverListener(ActionListener registerObserverActionListener) {
        this.rent_btn.addActionListener(registerObserverActionListener);
    }
}
