package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.BankPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface BankPaymentRepository extends JpaRepository<BankPayment, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM BankPayment a WHERE a.id = :id")
    void deleteBankPaymentById(@Param("id") Long id);

}
