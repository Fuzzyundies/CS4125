/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.UserInterfaces;


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentOutView extends JFrame
{
    private JPanel panel;
    private JTextField title;
    private JLabel titleL;
    private JTextField description;
    private JLabel descriptionL;
    private JTextField price;
    private JLabel priceL;
    private JComboBox category;
    private JLabel categoryL;
    
    private JButton add;
    private JButton cancel;
    
    public RentOutView()
    {
        panel = new JPanel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        displayRentOutView();
    }
    
    public void displayRentOutView()
    {
        //-------Temp----Need to add category objects to category Spinner
        String [] temp = {"Old BBQ", "New BBQ"};
        this.setBounds(500, 250, 300, 300);
        
        //label.setHorizontalAlignment(JLabel.CENTER);
        //label.setVerticalAlignment(JLabel.CENTER);
        title = new JTextField();
        titleL = new JLabel("Title");
        titleL.setHorizontalAlignment(JLabel.CENTER);
        description = new JTextField();
        descriptionL = new JLabel("Description");
        descriptionL.setHorizontalAlignment(JLabel.CENTER);
        category = new JComboBox(temp);
        category.setEditable(false);
        categoryL = new JLabel("Category");
        categoryL.setHorizontalAlignment(JLabel.CENTER);
        price = new JTextField();
        priceL = new JLabel("Price");
        priceL.setHorizontalAlignment(JLabel.CENTER);
        add = new JButton("Add");
        cancel = new JButton("Cancel");
        
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.add(titleL);
        panel.add(title);
        panel.add(descriptionL);
        panel.add(description);
        panel.add(categoryL);
        panel.add(category);
        panel.add(priceL);
        panel.add(price);
        panel.add(add);
        panel.add(cancel);
        
        panel.revalidate();
        
        this.setVisible(true);
        this.setTitle("RentOutView");
    }
    
    public String getTitle()
    {
        return title.getText();
    }
    public String getDescription()
    {
        return description.getText();
    }
    public String getPrice()
    {
        return price.getText();
    }
    /*
    public Category getName()
    {
        return category;    //I dunno yet
    }
    */
    
    
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
