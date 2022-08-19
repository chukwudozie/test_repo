package org.design.bonpellz.service.impl;

import org.design.bonpellz.exceptions.EmailException;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.repository.UserRepository;
import org.design.bonpellz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.design.bonpellz.utility.MessageBody;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Value("${spring.mail.password}")
    private String emailPassword;

    private Session session;


    public void  init(){
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
    public void sendMail(EarlyAccessRequest request, String referralCode) {
        init();
        try {
            MimeMessage message = new MimeMessage(session);
            System.out.println("I got here");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject(MessageBody.welcomeMessageSubject);
            helper.setFrom(emailSender);
            helper.setTo(request.getEmail());
            String content =  "<b style='color: grey;'>Hi [[name]]</b>,"
                    +"<br>"+MessageBody.welcomeMessage;
            content = content.replace("[[name]]",request.getName());
            content = content.replace("[[code]]",referralCode);
            helper.setText(content, true);
            Transport.send(message);

            System.out.println("Message sent ");
        } catch (MessagingException e){
            throw new EmailException("Email not sent successfully, Please check the credentials properly");
        }


    }

}
