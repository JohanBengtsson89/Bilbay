package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Address;
import com.BilBay.bilbay.repositories.AddressRepository;
import com.BilBay.bilbay.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("address")
//    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("auth/address/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Address getAddressById (@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("auth/address/update")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Address updateAddress (@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @DeleteMapping("auth/address/delete/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deleteById (@PathVariable Long id) {
        addressService.deleteById(id);
        return "Address has been deleted";
    }

}
