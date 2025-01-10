package com.address.book.exception;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
        super("Address not found");
    }

}
