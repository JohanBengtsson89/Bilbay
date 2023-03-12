package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPaymentTransactionRepository extends JpaRepository<DeliveryPaymentTransaction, Long> {
    DeliveryPaymentTransaction getDeliveryPaymentTransactionById(Long id);
}
