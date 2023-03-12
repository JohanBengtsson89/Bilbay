package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import com.BilBay.bilbay.repositories.DeliveryPaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPaymentTransactionService {
    @Autowired
    private final DeliveryPaymentTransactionRepository deliveryPaymentTransactionRepository;

    public DeliveryPaymentTransactionService(DeliveryPaymentTransactionRepository deliveryPaymentTransactionRepository) {
        this.deliveryPaymentTransactionRepository = deliveryPaymentTransactionRepository;
    }

    public DeliveryPaymentTransaction createDeliveryPayment(DeliveryPaymentTransaction deliveryPaymentTransaction) {
        return deliveryPaymentTransactionRepository.save(deliveryPaymentTransaction);
    }
}
