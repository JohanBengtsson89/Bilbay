package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import com.BilBay.bilbay.services.DeliveryPaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DeliveryPaymentTransactionController {
    @Autowired
    DeliveryPaymentTransactionService deliveryPaymentTransactionService;
    @PostMapping("delivery-payment")
    public DeliveryPaymentTransaction createDeliveryPayment(@RequestBody DeliveryPaymentTransaction deliveryPaymentTransaction){
        return deliveryPaymentTransactionService.createDeliveryPayment(deliveryPaymentTransaction);
    }

    @GetMapping("delivery-payment/{id}")
    public DeliveryPaymentTransaction getDeliveryPaymentTransactionById(@PathVariable Long id){
       return deliveryPaymentTransactionService.getDeliveryPaymentById(id);
    }

}
