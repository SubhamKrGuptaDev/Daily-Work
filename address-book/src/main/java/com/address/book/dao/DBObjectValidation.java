package com.address.book.dao;

import com.address.book.entity.Address;
import com.address.book.exception.AddressEmailNotValidException;
import com.address.book.exception.AddressLandlineNotValidException;
import com.address.book.exception.AddressMobileNoNotValidException;
import com.address.book.repository.AddressRepository;
import org.springframework.stereotype.Component;

@Component
public class DBObjectValidation {

    private final AddressRepository addressRepository;

    public DBObjectValidation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public boolean validateAddress(Address address) {
        if(address.getEmail() == null || address.getEmail().isEmpty() || address.getEmail().isBlank()) {
            throw new AddressEmailNotValidException();
        }

        if(address.getMobileNo() == null || address.getMobileNo().isEmpty() || address.getMobileNo().isBlank()) {
            throw new AddressMobileNoNotValidException();
        }

        if(address.getLandline() == null || address.getLandline().isEmpty() || address.getLandline().isBlank()) {
            throw new AddressLandlineNotValidException();
        }

        return addressRepository.existsByEmailOrMobileNoOrLandline(address.getEmail(),
                address.getMobileNo(),
                address.getLandline());
    }


}
