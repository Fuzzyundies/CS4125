/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;

/**
 *
 * @author Eric Lambert
 */
import Business.Product.Product;
import DatabaseManagement.ProductDAO;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ProfileView extends JFrame {

    private JPanel mainPanel, infoPanel, buttonPanel;
    private JLabel nameL;
    private JLabel ratingL;
    private JLabel userNameL;
    private JLabel userRatingL;
    private JButton homeBtn;
    private JButton histBtn;
    private JButton subBtn;
    private JButton editBtn;

    //These for edit profile
    private JButton saveBtn;
    private JButton cancelBtn;
    private JTextField usernameInput;
    private JPasswordField firstPasswordInput;
    private JPasswordField secondPasswordInput;
    
    
    // ------------- History Window -----------
    private JList listOfHistory;
    private JButton selectBtn;
    // ----------------------------------------


    /*
    Must take in the username, and then check against the database for the information.
    Current parts are either commented out or using placeholder values.
    Any place holder variable starts with "ph"
     */
    //Accept Customer instead of values.
    public ProfileView(String user, double rating) {
        //get Information from the database about the user
        mainPanel = new JPanel();
        displayProfile();
    }

    public void displayProfile() {
        mainPanel.removeAll();
        infoPanel = new JPanel();
        buttonPanel = new JPanel();
        String user = "Temporary Bean";
        double rating = 3.6;
        //setDefaultCloseOperation() see if can make it go back to home
        this.setTitle("Profile");
        this.add(mainPanel);
        this.setBounds(50, 50, 700, 100);

        mainPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonPanel.setLayout(new GridLayout(1, 4, 2, 2));
        infoPanel.setLayout(new GridLayout(2, 2, 5, 5));

        nameL = new JLabel("User Name:");
        userNameL = new JLabel(user);
        ratingL = new JLabel("Rating:");
        userRatingL = new JLabel(rating + ""); //Didn't lie .toString()
        infoPanel.add(nameL);
        infoPanel.add(userNameL);
        infoPanel.add(ratingL);
        infoPanel.add(userRatingL);

        homeBtn = new JButton("Back");
        histBtn = new JButton("History");
        subBtn = new JButton("Renew Subscription");
        editBtn = new JButton("Edit Profile");
        buttonPanel.add(subBtn);
        buttonPanel.add(histBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(homeBtn);

        mainPanel.add(infoPanel);
        mainPanel.add(buttonPanel);
        
        mainPanel.revalidate();
        mainPanel.repaint();
        pack();
        this.setVisible(true);
    }
    
    public void createEditProfileWindow() {

        //init components
        usernameInput = new JTextField();
        firstPasswordInput = new JPasswordField();
        secondPasswordInput = new JPasswordField();
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        this.setBounds(450, 250, 400, 200);
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(4, 2));

        //add in fields
        mainPanel.add(new JLabel("Username:"));
        mainPanel.add(usernameInput);
        mainPanel.add(new JLabel("Password:"));
        mainPanel.add(firstPasswordInput);
        mainPanel.add(new JLabel("Confirm Password:"));
        mainPanel.add(secondPasswordInput);
        mainPanel.add(saveBtn);
        mainPanel.add(cancelBtn);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void createHistoryWindow()
    {
        System.out.println("Displaying user rental history...");
        
        Product [] products = ProductDAO.getHistory(/*USE USER ID*/1);
        
        this.setBounds(450, 250, 400, 200);
        
        selectBtn = new JButton("Select");
        cancelBtn = new JButton("Back");
        listOfHistory = new JList(products);
        
        mainPanel.removeAll();
        
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(new JScrollPane(listOfHistory));
        
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new GridLayout(1, 2));
        btnContainer.add(cancelBtn);
        btnContainer.add(selectBtn);
        
        mainPanel.add(btnContainer);
        
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void addSubscriptionButtonListener(ActionListener listener) {
        subBtn.addActionListener(listener);
    }

    public void addHistBtnListener(ActionListener listener) {
        histBtn.addActionListener(listener);
    }

    public void addEditBtnListener(ActionListener listener) {
        editBtn.addActionListener(listener);
    }

    public void addHomeBtnListener(ActionListener listener) {
        homeBtn.addActionListener(listener);
    }
    
    public void addBackBtnListner(ActionListener backToProfileListener) {
        this.cancelBtn.addActionListener(backToProfileListener);
    }
    
    public void addSelectBtnListener(ActionListener listener)
    {
        selectBtn.addActionListener(listener);
    }
}
