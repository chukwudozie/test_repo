package org.design.bonpellz.service.impl;

import org.design.bonpellz.exceptions.EmailException;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.EmailService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static org.design.bonpellz.utility.MessageBody.*;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String emailSender;

    @Value("${spring.mail.password}")
    private String emailPassword;

    private Session session;


    public void init() {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSender, emailPassword);
            }
        });

        session.setDebug(true);

    }


    @Override
    public void sendMailWithImage(EarlyAccessRequest request, String referralCode, Long userId) {
     init();
        Message message = new MimeMessage(session);
        try{
            message.setFrom(new InternetAddress(emailSender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getEmail()));
            message.setSubject(welcomeMessageSubject);
            message.setSentDate(new Date());
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            Long value = userId + 1000L;
            String placeInLine = String.valueOf(value);
            System.out.println(value);

            welcomeMessage = welcomeMessage.replace("[[name]]", request.getName());
            welcomeMessage = welcomeMessage.replace("[[code]]", referralCode);
            welcomeMessage = welcomeMessage.replace("[[position]]",placeInLine);
            messageBodyPart.setContent(welcomeMessage, "text/html");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (Exception e){
            throw new EmailException("Error sending mail");
        }



    }

}
