package org.design.bonpellz.controller;

import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bonpellz/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> requestForEarlyAccess(@Valid @RequestBody EarlyAccessRequest request, BindingResult result){

        return new ResponseEntity<>(userService.getEarlyAccess(request, result), HttpStatus.OK);
    }
}

