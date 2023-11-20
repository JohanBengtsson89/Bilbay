package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.PaymentTransaction;
import com.BilBay.bilbay.repositories.PaymentTransactionRepository;
import com.BilBay.bilbay.services.PaymentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class PaymentTransactionController {
    @Autowired
    PaymentTransactionService paymentTransactionService;

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;

    @PostMapping("payment-transaction")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public PaymentTransaction createPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
        return paymentTransactionService.createPaymentTransaction(paymentTransaction);}

    @PutMapping("payment/{id}/{successful}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updatePayTransactionStatus (@PathVariable Long id, @PathVariable boolean successful) {
        if (!paymentTransactionRepository.findById(id).isEmpty()){
            paymentTransactionService.updatePaymentTransactionStatus(id, successful);
            return "payment status has been updated.";
        }
        return "Payment not found";
    }
}
