package org.design.bonpellz.service;

import org.design.bonpellz.payload.EarlyAccessRequest;


public interface EmailService {


    void sendMail(EarlyAccessRequest request, String referralCode);

}
