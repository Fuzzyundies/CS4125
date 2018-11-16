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
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfileView extends JFrame {

    private JPanel mainPanel, infoPanel, buttonPanel;
    private final JLabel nameL;
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


    /*
    Must take in the username, and then check against the database for the information.
    Current parts are either commented out or using placeholder values.
    Any place holder variable starts with "ph"
     */
    //Accept Customer instead of values.
    public ProfileView(String user, double rating) {
        mainPanel = new JPanel();
        infoPanel = new JPanel();
        buttonPanel = new JPanel();

        //get Information from the database about the user
        user = "Temporary Bean";
        rating = 3.6;
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

        this.setVisible(true);
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
}
