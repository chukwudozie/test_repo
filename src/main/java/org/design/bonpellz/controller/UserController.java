package org.design.bonpellz.controller;

import org.design.bonpellz.domain.Users;
import org.design.bonpellz.payload.EarlyAccessRequest;
import org.design.bonpellz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bonpellz/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> requestForEarlyAccess(@Valid @RequestBody EarlyAccessRequest request,
     BindingResult result, @RequestParam(value= "referralCode", defaultValue = "", required = false) String referralCode){
        return new ResponseEntity<>(userService.getEarlyAccess(request, result, referralCode), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Users>> getAllRegisteredUsers(){
        return new ResponseEntity<>(userService.getAllSavedUsers(),HttpStatus.OK);
    }
}

