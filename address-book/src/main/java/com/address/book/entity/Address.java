package com.address.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    private String name;
    private String email;
    private String mobileNo;
    private String country;
    private String state;
    private String city;
    private String pinCode;
    private String description;

}
