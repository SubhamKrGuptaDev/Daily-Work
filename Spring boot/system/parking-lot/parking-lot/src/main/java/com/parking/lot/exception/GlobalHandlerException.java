package com.parking.lot.exception;

import com.parking.lot.dto.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception handler implementation
 */
@RestControllerAdvice
public class GlobalHandlerException {

    /**
     * Global custom Exception handler method to catch the Global Exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(GlobalException ex) {
        return new ResponseEntity<>(setErrorMessage(ex.getMessage(), 401),
                HttpStatus.UNAUTHORIZED);
    }

    /**
     * Parent Exception for all the exception and catch application exception
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        return new ResponseEntity<>(setErrorMessage(ex.getMessage(), 400),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Set Error Response change the response
     *
     * @param message
     * @param status
     * @return
     */
    private ErrorResponse setErrorMessage(String message, Integer status) {
        return new ErrorResponse(message, status);
    }

}
