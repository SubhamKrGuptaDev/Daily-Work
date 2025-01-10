package com.address.book.service;

import com.address.book.dao.AddressDao;
import com.address.book.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findById(Integer id) {
        return addressDao.findById(id);
    }

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public void delete(Integer addressId) {
        addressDao.delete(addressId);
    }
}
