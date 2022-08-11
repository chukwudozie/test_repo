package org.design.bonpellz.service;

import org.design.bonpellz.payload.EmailDetails;

public interface EmailService {

    String sendEmail(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails details);
}
