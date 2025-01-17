package com.address.book.controller;

import com.address.book.entity.Address;
import com.address.book.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.address.book.constants.CommonConstants.DELETE_MESSAGE_SUCCESSFUL;

/**
 *
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     *
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        System.out.println("Get All");
        return ResponseEntity.ok(addressService.findAll());
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @GetMapping(params = "id")
    public ResponseEntity<Address> getById(@RequestParam Integer id) {
        System.out.println("Get Id: " + id);
        Address existing = addressService.findById(id);
        return ResponseEntity.ok(existing);
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        System.out.println("Create " + address.toString());
        return ResponseEntity.ok(addressService.save(address));
    }

    /**
     *
     *
     * @param address
     * @return
     */
    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address) {
        System.out.println("Update: " + address.toString());
        return ResponseEntity.ok(addressService.update(address));
    }

    /**
     *
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Map<String, String>> delete(@RequestParam Integer id) {
        System.out.println("delete data: " + id);
        addressService.delete(id);
        // Message Mapping
        Map<String, String> map = new HashMap<>();
        map.put("message", DELETE_MESSAGE_SUCCESSFUL);
        return ResponseEntity.ok(map);
    }

}
