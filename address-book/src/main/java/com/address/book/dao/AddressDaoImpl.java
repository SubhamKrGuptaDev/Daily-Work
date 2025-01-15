package com.address.book.dao;

import com.address.book.entity.Address;
import com.address.book.exception.AddressNotFoundException;
import com.address.book.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class AddressDaoImpl implements AddressDao {

    private final AddressRepository addressRepository;

    public AddressDaoImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     *
     *
     * @return
     */
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(AddressNotFoundException::new);
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @Override
    public Address update(Address address) {
        if(address.getId() == null) {
            throw new AddressNotFoundException();
        }

        if(!addressRepository.existsById(address.getId())) {
            throw new AddressNotFoundException();
        }

        return addressRepository.save(address);
    }

    /**
     *
     *
     * @param addressId
     */
    @Override
    public void delete(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
