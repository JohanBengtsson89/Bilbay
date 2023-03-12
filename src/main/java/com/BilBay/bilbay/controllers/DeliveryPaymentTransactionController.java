package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import com.BilBay.bilbay.services.DeliveryPaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverypayment/")
public class DeliveryPaymentTransactionController {
    @Autowired
    private final DeliveryPaymentTransactionService deliveryPaymentTransactionService;

    public DeliveryPaymentTransactionController(DeliveryPaymentTransactionService deliveryPaymentTransactionService) {
        this.deliveryPaymentTransactionService = deliveryPaymentTransactionService;
    }

    @PostMapping("createDeliveryPayment")
    DeliveryPaymentTransaction createDeliveryPayment(@RequestBody DeliveryPaymentTransaction deliveryPaymentTransaction) {
        return deliveryPaymentTransactionService.createDeliveryPayment(deliveryPaymentTransaction);
    }
}
