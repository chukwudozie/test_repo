package org.design.bonpellz.service.impl;

import org.design.bonpellz.payload.EmailDetails;
import org.design.bonpellz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;


    @Override
    public String sendEmail(EmailDetails emailDetails) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailSender);
            message.setTo(emailDetails.getRecipient());
            message.setText(emailDetails.getMessageBody());
            message.setSubject(emailDetails.getSubject());

            javaMailSender.send(message);

            return "Mail Sent successfully!";
        }catch (Exception e){
            System.err.println(e.getCause().getLocalizedMessage());
            return "Error occurred while sending Mail";
        }

    }

    @Override
    public String sendMailWithAttachment(EmailDetails details){
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be sent
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(emailSender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMessageBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    Objects.requireNonNull(file.getFilename()), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (MessagingException e){
            System.err.println(e.getCause().getLocalizedMessage());
            return "Error occurred while sending Mail";
        }
    }
}
