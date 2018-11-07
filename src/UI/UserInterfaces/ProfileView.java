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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProfileView extends JFrame
{
    private JPanel panel;
    private JLabel nameL, ratingL, userNameL, userRatingL;
    private JButton homeBtn, histBtn, subBtn, editBtn;
    
    /*
    Must take in the username, and then check against the database for the information.
    Current parts are either commented out or using placeholder values.
    Any place holder variable starts with "ph"
    */
    public ProfileView(String user)
    {
        //get Information from the database about the user
        panel = new JPanel();
        //setDefaultCloseOperation() see if can make it go back to home
        
        this.add(panel);
        this.setBounds(50, 50, 200, 200);
        
        panel.setLayout(new GridLayout());
        
        homeBtn = new JButton("Home");
        histBtn = new JButton("History");
        subBtn = new JButton("Renew\nSubscription");
        editBtn = new JButton("Edit\nProfile");
    }
    
}


