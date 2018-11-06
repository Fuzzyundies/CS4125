/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Benjamin Grimes
 */
public class LoginView extends JFrame
{
    private JPanel panel;
    private JButton signup_btn;
    private JButton login_btn;
    private JTextField uname_textF;
    private JTextField pw_textF;
    
    public LoginView()
    {
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(panel);
        displayLoginView();
    }
    
    public void displayLoginView()
    {
        this.setBounds(50, 50, 200, 100);
        
        uname_textF = new JTextField();
        pw_textF = new JPasswordField();
        
        signup_btn = new JButton("Sign up");
        login_btn = new JButton("Login");
        
        panel.removeAll();
        
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Username:"));
        panel.add(uname_textF);
        panel.add(new JLabel("Password:"));
        panel.add(pw_textF);
        panel.add(signup_btn);
        panel.add(login_btn);
        
        panel.revalidate();
        
        this.setVisible(true);
        this.setTitle("Login");
    }
    
    public String getName()
    {
        return uname_textF.getText();
    }
    
    public String getPassword()
    {
        return pw_textF.getText();
    }
    
    public void resetNameText()
    {
        uname_textF.setText("");
    }
    
    public void resetPasswordText()
    {
        pw_textF.setText("");
    }
    
    public void addLoginListener(ActionListener listenerForLoginBtn)
    {
        login_btn.addActionListener(listenerForLoginBtn);
    }
    
    public void displayErrorMessage(String errorMsg)
    {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
}
