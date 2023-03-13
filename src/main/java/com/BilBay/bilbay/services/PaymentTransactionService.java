package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.PaymentTransaction;
import com.BilBay.bilbay.repositories.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTransactionService {
    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;
    public PaymentTransaction createPaymentTransaction(PaymentTransaction paymentTransaction){
        return paymentTransactionRepository.save(paymentTransaction);
    }
}
