/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


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
        this.setBounds(500, 250, 200, 225);
        
        rent = new JButton("Rent");
        rent.setAlignmentX(Component.CENTER_ALIGNMENT);
        rentOut = new JButton("Rent out");
        rentOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewProfile = new JButton("View Profile");
        viewProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
        signOut = new JButton("Sign Out");
        signOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(Box.createRigidArea(new Dimension(100,20)));
        panel.add(rent);
        panel.add(Box.createRigidArea(new Dimension(100,15)));
        panel.add(rentOut);
        panel.add(Box.createRigidArea(new Dimension(100,15)));
        panel.add(viewProfile);
        panel.add(Box.createRigidArea(new Dimension(100,15)));
        panel.add(signOut);
        
        panel.revalidate();
        
        this.setVisible(true);
        this.setTitle("Home");
    }
    
    public void addRentListener(ActionListener listenerForRent)
    {
        rent.addActionListener(listenerForRent);
    }
    public void addRentOutListener(ActionListener listenerForRentOut)
    {
        rentOut.addActionListener(listenerForRentOut);
    }
    public void addViewProfileListener(ActionListener listenerForViewProfile)
    {
        viewProfile.addActionListener(listenerForViewProfile);
    }
    public void addSignOutListener(ActionListener listenerForSignOut)
    {
        signOut.addActionListener(listenerForSignOut);
    }
}
