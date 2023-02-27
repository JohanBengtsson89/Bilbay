package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.BankPayment;
import com.BilBay.bilbay.repositories.BankPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankPaymentService {

    @Autowired
    BankPaymentRepository bankPaymentRepository;

    public BankPayment createBankPayment(BankPayment bankPayment) {
        return bankPaymentRepository.save(bankPayment);
    }

    public String deleteBankPaymentById (Long id){
        bankPaymentRepository.deleteById(id);
        return "Bank Payment has been deleted";
    }

    public BankPayment updateBankPayment (BankPayment bankPayment){
        return bankPaymentRepository.save(bankPayment);
    }

}
