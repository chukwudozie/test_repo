package org.design.bonpellz.service;

import org.design.bonpellz.payload.EarlyAccessRequest;


public interface EmailService {


    void  sendWithImage(EarlyAccessRequest request);

}
