/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessManagement;

import Business.Product.Product;
import Business.User.Customer;

import Business.User.Observer;
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
    private Customer renter;
    private Customer leaser;

    // NOTE: Limited to 99 emails every 24 hours. 
    // Uses Google SMTP instead of AWS SES because AWS costs approx 10 cent per email.
    private final static String username = "BeanSquadRental@gmail.com";
    private final static String password = "squad1234";
    private Timestamp timestamp;

    public Notifcation(Customer renter, Customer leaser) {
        this.renter = renter;
        this.leaser = leaser;
        this.observers = new ArrayList();
    }

    public Notifcation() {
        this.observers = new ArrayList<>();
    }

    public Customer getRenter() {
        return renter;
    }

    public Customer getLeaser() {
        return leaser;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void sendEmail(Customer r, Customer l) {
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

        String r_email = r.getEmail();
        String l_email = l.getEmail();

        int r_code = 0; // generate renter code for locker
        int l_code = 0; // generate leaser code for locker

        String r_msg = "";
        String l_msg = "";
        String email_subject = "";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("BeanSquadRental@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(r_email));
            message.setSubject("Testing Subject");
            message.setText(r_msg);
            Transport.send(message);
            System.out.println("Sent to customer...");

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("BeanSquadRental@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(l_email));
            message.setSubject("Testing Subject");
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
