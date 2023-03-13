package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.PaymentTransaction;
import com.BilBay.bilbay.services.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PaymentTransactionController {
    @Autowired
    PaymentTransactionService paymentTransactionService;
    @PostMapping("payment-transaction")
    public PaymentTransaction createPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
        return paymentTransactionService.createPaymentTransaction(paymentTransaction);
    }
}
