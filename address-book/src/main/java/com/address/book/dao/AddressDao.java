package com.address.book.dao;

import com.address.book.entity.Address;

import java.util.List;

/**
 *
 */
public interface AddressDao {

    List<Address> findAll();

    Address findById(Integer id);
    Address save(Address address);
    Address update(Address address);
    void delete(Integer addressId);

}
