package com.address.book.exception;

public class AddressValidationException extends RuntimeException {

    public AddressValidationException() {
        super("Address validation failed");
    }

}
