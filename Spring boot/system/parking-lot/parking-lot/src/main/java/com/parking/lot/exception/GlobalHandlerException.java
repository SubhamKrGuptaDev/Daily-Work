package com.parking.lot.exception;

import com.parking.lot.dto.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(GlobalException ex) {
        return new ResponseEntity<>(setErrorMessage(ex.getMessage(), 401),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        return new ResponseEntity<>(setErrorMessage(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse setErrorMessage(String message, Integer status) {
        return new ErrorResponse(message, status);
    }

}
