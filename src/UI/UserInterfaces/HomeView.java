/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeView extends JFrame {

    private JPanel panel;
    private JPanel buttonPanel;
    private JButton rent;
    private JButton rentOut;
    private JButton viewProfile;
    private JButton signOut;

    public HomeView() {
        panel = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        displayHomeView();
    }

    public void displayHomeView() {
        this.setBounds(50, 50, 400, 225);

        rent = new JButton("Rent");
        rent.setAlignmentX(Component.CENTER_ALIGNMENT);
        rentOut = new JButton("Rent out");
        rentOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewProfile = new JButton("View Profile");
        viewProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
        signOut = new JButton("Sign Out");
        signOut.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(rent);
        buttonPanel.add(rentOut);
        buttonPanel.add(viewProfile);
        buttonPanel.add(signOut);

        panel.add(buttonPanel);
        panel.revalidate();
        pack();
        this.setVisible(true);
        this.setTitle("Home");
    }

    public void addRentListener(ActionListener listenerForRent) {
        rent.addActionListener(listenerForRent);
    }

    public void addRentOutListener(ActionListener listenerForRentOut) {
        rentOut.addActionListener(listenerForRentOut);
    }

    public void addViewProfileListener(ActionListener listenerForViewProfile) {
        viewProfile.addActionListener(listenerForViewProfile);
    }

    public void addSignOutListener(ActionListener listenerForSignOut) {
        signOut.addActionListener(listenerForSignOut);
    }
}
