package org.design.bonpellz.service.impl;

import org.design.bonpellz.exceptions.EmailException;
import org.design.bonpellz.exceptions.ValidationException;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.design.bonpellz.utility.MessageBody;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
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
            message.setSubject(MessageBody.welcomeMessageSubject+request.getName()+"!");

            // Now set the actual message
            message.setText(MessageBody.welcomeMessage);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    @Override
    public void  sendWithImage(EarlyAccessRequest request) {

        String host = "smtp.gmail.com";


        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSender, emailPassword);
            }
        });

        session.setDebug(true);

        String from = emailSender;
        String to = request.getEmail();

        try {
            MimeMessage message = new MimeMessage(session);
            System.out.println("I got here");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject(MessageBody.welcomeMessageSubject);
            helper.setFrom(from);
            helper.setTo(to);
            String content =  "<b style='color: grey;'>Hi [[name]]</b>,"
                    +"<br>"+MessageBody.welcomeMessage;
            content = content.replace("[[name]]",request.getName());
            helper.setText(content, true);

            Transport.send(message);

            System.out.println("Message sent ");
        } catch (MessagingException e){
            throw new EmailException("Email not sent successfully, Please check the credentials properly");
        }


    }

}
