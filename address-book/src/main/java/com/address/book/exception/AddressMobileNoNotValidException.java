package com.address.book.exception;

public class AddressMobileNoNotValidException extends RuntimeException {

    public AddressMobileNoNotValidException() {
        super("Address mobile number is not valid");
    }

}
