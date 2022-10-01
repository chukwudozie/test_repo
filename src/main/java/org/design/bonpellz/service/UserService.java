package org.design.bonpellz.service;

import org.design.bonpellz.domain.Users;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {

     Users getEarlyAccess(EarlyAccessRequest request, BindingResult result, String referralCode);
     List<Users> getAllSavedUsers();
}
