package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.CardPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPaymentRepository extends JpaRepository<CardPayment, Long> {

}
