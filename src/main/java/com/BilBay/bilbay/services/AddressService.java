package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Address;
import com.BilBay.bilbay.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    public Address updateAddress (Address address) {
        return addressRepository.save(address);
    }

    public String deleteById (Long id) {
        addressRepository.deleteById(id);
        return "Address has been deleted";
    }

}
