/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;

import java.awt.GridLayout;
//import java.awt.Insets;
import java.awt.event.ActionListener;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HomeView extends JFrame
{
    private JPanel panel;
    private JButton rent;
    private JButton rentOut;
    private JButton viewProfile;
    private JButton signOut;
    
    public HomeView()
    {
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(panel);
        displayHomeView();
    }
    
    public void displayHomeView()
    {
        this.setBounds(50, 50, 200, 100);
        
        rent = new JButton("Rent");
        rentOut = new JButton("Rent out");
        
        panel.removeAll();
        
        VBox vbox = new VBox();
        
        //vbox.setPadding();
        vbox.setSpacing(10);
        
        panel.add(vbox);
        //panel.add(new JLabel("Username:"));
        panel.add(uname_textF);
        panel.add(new JLabel("Password:"));
        panel.add(pw_textF);
        panel.add(signup_btn);
        panel.add(login_btn);
        
        panel.revalidate();
        
        this.setVisible(true);
        this.setTitle("Login");
    }
}
