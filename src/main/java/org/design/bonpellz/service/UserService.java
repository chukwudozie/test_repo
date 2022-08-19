package org.design.bonpellz.service;

import org.design.bonpellz.domain.Users;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface UserService {

     Users getEarlyAccess(EarlyAccessRequest request, BindingResult result, String referralCode);
}
