package org.design.bonpellz.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class BonPellzExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> registrationRequestHandler(ValidationException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ExceptionPayLoad payLoad = new ExceptionPayLoad(e.getMessage(),e, badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(payLoad,badRequest);

    }
}
