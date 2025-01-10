package com.address.book.service;

import com.address.book.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAll();

    Address findById(Integer id);
    Address save(Address address);
    Address update(Address address);
    void delete(Integer addressId);

}
