package org.design.bonpellz.service.impl;

import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.design.bonpellz.utility.MessageBody;

import javax.mail.*;
import javax.mail.internet.*;
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

    public void sendMail2(EarlyAccessRequest request) {

        String to = request.getEmail();

        String username = "1196c2a9a28310";
        String password  = "6232b5bd0de4a2";


        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSender, emailPassword);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("support@bonpellz.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("emkychuks062@gmail.com"));
            message.setSubject(MessageBody.welcomeMessageSubject+" "+ request.getName()+"!");

            String msg = "<b>This is my first email using JavaMailer Mailtrap</b>";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            System.out.println("Sent message successfully....");
            Transport.send(message);

        } catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
