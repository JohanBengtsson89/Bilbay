package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import com.BilBay.bilbay.repositories.DeliveryPaymentTransactionRepository;
import com.BilBay.bilbay.services.DeliveryPaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class DeliveryPaymentTransactionController {
    @Autowired
    DeliveryPaymentTransactionService deliveryPaymentTransactionService;
    @Autowired
    DeliveryPaymentTransactionRepository deliveryPaymentTransactionRepository;
    @PostMapping("delivery-payment")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public DeliveryPaymentTransaction createDeliveryPayment(@RequestBody DeliveryPaymentTransaction deliveryPaymentTransaction){
        return deliveryPaymentTransactionService.createDeliveryPayment(deliveryPaymentTransaction);
    }

    @GetMapping("delivery-payment/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public DeliveryPaymentTransaction getDeliveryPaymentTransactionById(@PathVariable Long id){
       return deliveryPaymentTransactionService.getDeliveryPaymentById(id);
    }

    @PutMapping("delivery/{id}/{successful}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateProductStatus (@PathVariable Long id, @PathVariable boolean successful) {
        if (!deliveryPaymentTransactionRepository.findById(id).isEmpty()){
            deliveryPaymentTransactionService.updateDeliveryPaymentStatus(id, successful);
            return "Delivery payment status has been updated.";
        }
        return "Delivery not found";
    }
}
