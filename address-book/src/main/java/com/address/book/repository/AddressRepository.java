package com.address.book.repository;

import com.address.book.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Boolean existsByEmailOrMobileNoOrLandline(String email, String mobileNo, String landline);

    Address findFirstByOrderByIdDesc();

}
