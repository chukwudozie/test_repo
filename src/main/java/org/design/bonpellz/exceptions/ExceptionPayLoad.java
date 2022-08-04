package org.design.bonpellz.exceptions;


import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ExceptionPayLoad {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime time;

    public ExceptionPayLoad(String message, Throwable t, HttpStatus status, ZonedDateTime time){
        this.message = message;
        this.status = status;
        this.time = time;
    }
}
