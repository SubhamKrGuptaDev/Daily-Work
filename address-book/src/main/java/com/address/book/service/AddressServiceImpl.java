package com.address.book.service;

import com.address.book.dao.AddressDao;
import com.address.book.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    /**
     *
     *
     * @return
     */
    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @Override
    public Address findById(Integer id) {
        return addressDao.findById(id);
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @Override
    public Address update(Address address) {
        return addressDao.update(address);
    }

    /**
     *
     *
     * @param addressId
     */
    @Override
    public void delete(Integer addressId) {
        addressDao.delete(addressId);
    }
}
