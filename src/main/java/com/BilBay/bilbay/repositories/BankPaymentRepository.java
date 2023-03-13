package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.BankPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankPaymentRepository extends JpaRepository<BankPayment, Long> {

   BankPayment payForProduct(Long id);

}
