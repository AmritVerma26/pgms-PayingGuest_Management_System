package com.maveric.pgms.exceptionhandlers;

import com.maveric.pgms.exceptions.PayingGuestDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PayingGuestExceptionHandler {

    @ExceptionHandler(PayingGuestDetailsNotFoundException.class)
    public ResponseEntity<String> handlePayingGuestNotFoundException(PayingGuestDetailsNotFoundException e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

}
