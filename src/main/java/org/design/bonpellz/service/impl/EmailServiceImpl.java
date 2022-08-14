package org.design.bonpellz.service.impl;

import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String emailSender;

    @Value("${spring.mail.password}")
    private String emailPassword;


    @Override
    public void sendEmail(EarlyAccessRequest request) {


        String to = request.getEmail();

        // Sender's email ID needs to be mentioned
        String from = emailSender;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSender, emailPassword);
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Welcome to the BonPellz family "+request.getName()+"!");

            // Now set the actual message
            message.setText("Congratulations on taking your first step in the finest journey to" +
             "achieve true financial freedom. You are now part of a global community of parents and young" +
             "population of the African continent who are with us on a journey to groom a new prosperous african people...");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
