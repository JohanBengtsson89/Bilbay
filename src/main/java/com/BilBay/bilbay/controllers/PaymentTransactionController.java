package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.PaymentTransaction;
import com.BilBay.bilbay.repositories.PaymentTransactionRepository;
import com.BilBay.bilbay.services.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PaymentTransactionController {
    @Autowired
    PaymentTransactionService paymentTransactionService;

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;

    @PostMapping("payment-transaction")
    public PaymentTransaction createPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
        return paymentTransactionService.createPaymentTransaction(paymentTransaction);}

    @PutMapping("payment/{id}/{successful}")
    public String updatePayTransactionStatus (@PathVariable Long id, @PathVariable boolean successful) {
        if (!paymentTransactionRepository.findById(id).isEmpty()){
            paymentTransactionService.updatePaymentTransactionStatus(id, successful);
            return "payment status has been updated.";
        }
        return "Payment not found";
    }
}
