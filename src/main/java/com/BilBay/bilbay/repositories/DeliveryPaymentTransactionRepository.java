package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.DeliveryPaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryPaymentTransactionRepository extends JpaRepository<DeliveryPaymentTransaction, Long> {
    DeliveryPaymentTransaction getDeliveryPaymentTransactionById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE DeliveryPaymentTransaction u SET u.Successful = ?1 where u.id = ?2")
    void updateDeliveryPaymentTransaction(boolean successful, Long id);
}
