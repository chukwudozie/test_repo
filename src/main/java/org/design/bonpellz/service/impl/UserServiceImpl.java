package org.design.bonpellz.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.design.bonpellz.domain.Referral;
import org.design.bonpellz.domain.Users;
import org.design.bonpellz.exceptions.ValidationException;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.repository.ReferralRepository;
import org.design.bonpellz.repository.UserRepository;
import org.design.bonpellz.service.EmailService;
import org.design.bonpellz.service.ErrorValidationService;
import org.design.bonpellz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    ErrorValidationService validationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReferralRepository referralRepository;

    @Override
    public Users getEarlyAccess(EarlyAccessRequest request, BindingResult result, String referralCode) {

            if(userRepository.existsByEmail(request.getEmail()))
                throw new ValidationException("Email already Exists");

            ResponseEntity<?> validations = validationService.validate(result);
            if (validations != null){
                System.out.println(validations);
                throw new ValidationException(Objects.requireNonNull(validations.getBody()).toString());
            }
            String uniqueReferralCode = generateReferralCode(request);
            Users newUsers = new Users();
            newUsers.setActivated(false);
            newUsers.setPhoneNumber(request.getPhoneNumber());
            newUsers.setEmail(request.getEmail());
            newUsers.setName(request.getName());
            newUsers.setHearAboutUs(request.getHearAboutUs());
            newUsers.setUniqueReferralCode(uniqueReferralCode);

        if (!referralCode.isEmpty() && userRepository.existsByUniqueReferralCode(referralCode)){
                Users referer =  userRepository.findByUniqueReferralCode(referralCode).orElseThrow(
                      () -> new ValidationException("Invalid referral code"));
                Referral referral;
                if (referralRepository.existsByUserReferring(referer)){
                    referral = referralRepository.findByUserReferring(referer).get();
                }
                else {
                     referral = new Referral();
                    newUsers.setReferredBy(referer);
                }
            referral.setUserReferring(referer);
            referral.setCount(referral.getCount() + 1);
            referralRepository.save(referral);
            userRepository.save(referer);
            newUsers.setReferredBy(referer);
        }

        if (!userRepository.existsByUniqueReferralCode(referralCode) && !referralCode.isEmpty()){
            throw new ValidationException("INVALID REFERRAL CODE PROVIDED YOU  CAN CLICK on https://www.bonpellz.com TO BE REGISTERED WITHOUT REFERRAL!");
        }

        userRepository.save(newUsers);
        Long userId = newUsers.getId();
        emailService.sendMailWithImage(request, uniqueReferralCode,userId);
        System.out.println(newUsers.getUniqueReferralCode());
        return newUsers;
    }

    private String generateReferralCode(EarlyAccessRequest request) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        sb.append(request.getName(), 0, 4);
        for (int i = 0; i < 6;i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        log.info("your referral code is {}",sb);
        return sb.toString();

    }
}
