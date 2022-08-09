package org.design.bonpellz.service.impl;

import org.design.bonpellz.domain.Users;
import org.design.bonpellz.exceptions.ValidationException;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.repository.UserRepository;
import org.design.bonpellz.service.ErrorValidationService;
import org.design.bonpellz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ErrorValidationService validationService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Users getEarlyAccess(EarlyAccessRequest request, BindingResult result) {

            if(userRepository.existsByEmail(request.getEmail()))
                throw new ValidationException("Email already Exists");

            ResponseEntity<?> validations = validationService.validate(result);
            if (validations != null){
                System.out.println(validations);
                throw new ValidationException(Objects.requireNonNull(validations.getBody()).toString());
            }
            Users newUsers = new Users();
            newUsers.setActivated(false);
            newUsers.setPhoneNumber(request.getPhoneNumber());
            newUsers.setEmail(request.getEmail());
            newUsers.setName(request.getName());
            newUsers.setHearAboutUs(request.getHearAboutUs());
            System.out.println("I got here before save");
            userRepository.save(newUsers);
        return newUsers;
    }
}
