package com.address.book.controller;

import com.address.book.entity.Address;
import com.address.book.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.address.book.constants.CommonConstants.DELETE_MESSAGE_SUCCESSFUL;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping(params = "id")
    public ResponseEntity<Address> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.update(address));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        addressService.delete(id);
        return ResponseEntity.ok(DELETE_MESSAGE_SUCCESSFUL);
    }

}
