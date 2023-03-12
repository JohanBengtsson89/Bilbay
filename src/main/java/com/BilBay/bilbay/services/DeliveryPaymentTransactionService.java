package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import com.BilBay.bilbay.repositories.DeliveryPaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeliveryPaymentTransactionService {
    @Autowired
    DeliveryPaymentTransactionRepository deliveryPaymentTransactionRepository;

    public DeliveryPaymentTransaction createDeliveryPayment(DeliveryPaymentTransaction deliveryPaymentTransaction){
       return deliveryPaymentTransactionRepository.save(deliveryPaymentTransaction);
    }

    public DeliveryPaymentTransaction getDeliveryPaymentById(@PathVariable Long id){
        return deliveryPaymentTransactionRepository.getDeliveryPaymentTransactionById(id);
    }

    public void updateDeliveryPaymentStatus(Long id, boolean successful){
        deliveryPaymentTransactionRepository.updateDeliveryPaymentTransaction(successful, id);
    }

}
