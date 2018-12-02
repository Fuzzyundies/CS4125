/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import Business.Product.Product;

import Business.User.Observer;
import DatabaseManagement.CustomerDAO;
import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Benjamin Grimes
 */
public class Notifcation implements Subject //interface ideally
{

    private List<Observer> observers;
    private String renterEmail;
    private String leaserEmail;

    // NOTE: Limited to 99 emails every 24 hours. 
    // Uses Google SMTP instead of AWS SES because AWS costs approx 10 cent per email.
    private final static String username = "BeanSquadRental@gmail.com";
    private final static String password = "squad1234";
    private Timestamp timestamp;
    private String locationEmail = "KilMadeUp";
    private int lockerNumber = (int) Math.random() * 100 + 1;
    private String headerEmail = "Thank you for your patronage!";
    private String productEmail = "\nThe item in question is: ";
    private String pinEmail = "\nYour unique PIN is ";
    private String lockerEmail = "\nThe locker for the item is: ";
    private String signatureEmail = "\nSincerely,\nBeanSquad";
    private String productName = "\nTemp Name"; //Needs to be connected to the Transaction
    private String subjectEmail = "Product Rented"; //Needs to be connected to the Transaction
    private String r_msg = "";
    private String r_subject = "";
    private String l_msg = "";
    private String l_subject = "";
    
    public Notifcation(int renterID, int leaserID) 
    {
        this.renterEmail = getUserEmail(renterID);
        this.leaserEmail = getUserEmail(leaserID);
        this.observers = new ArrayList();
    }

    public Notifcation() {
        this.observers = new ArrayList<>();
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    private String getUserEmail(int userID)
    {
        CustomerDAO dbAccess = new CustomerDAO();
        return dbAccess.getEmail(userID);
    }
    
    public void setRenterEmail(String subject, String message)
    {
        this.r_subject = subject;
        this.r_msg = message;
    }
    
    public void setLeaserEmail(String subject, String message)
    {
        this.l_subject = subject;
        this.l_msg = message;
    }

    public void sendEmail() {
        // TODO implement sendEmail method
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        }
        );

        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("BeanSquadRental@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(renterEmail));
            message.setSubject(r_subject);
            message.setText(r_msg);
            Transport.send(message);
            System.out.println("Sent to customer...");

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("BeanSquadRental@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(leaserEmail));
            message.setSubject(l_subject);
            message.setText(l_msg);
            Transport.send(message);
            System.out.println("Sent email to leaser...");

            timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("Done..." + timestamp);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("Adding observer..\n");
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(observers.indexOf(o));
        System.out.println("Observer removed..\nLength of queue - " + observers.size());
    }

    @Override
    public void notify(Product product) {
        observers.forEach((o) -> { //for eacg loop
            o.update(product);
        });
    }

    public void notifyProductReturned(Product product) {
        notify(product);
    }

}
