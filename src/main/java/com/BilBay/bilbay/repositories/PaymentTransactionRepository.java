package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    List<PaymentTransaction> findBySuccessfulAndCreatedAt(boolean successful, LocalDate cutOffDate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PaymentTransaction u SET u.successful = ?1 where u.id = ?2")
    void updatePaymentTransaction (boolean successful, Long id);

}
