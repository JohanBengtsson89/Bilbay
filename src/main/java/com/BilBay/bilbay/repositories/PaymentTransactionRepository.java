package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    List<PaymentTransaction> findBySuccessfulAndCreatedAt(boolean successful, LocalDate cutOffDate);

}
