package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.BankPayment;
import com.BilBay.bilbay.services.BankPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BankPaymentController {

    @Autowired
    BankPaymentService bankPaymentService;

    @PostMapping("/bankpayment")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public BankPayment createBankpayment(@RequestBody BankPayment bankPayment){
        return bankPaymentService.createBankPayment(bankPayment);
    }

    @GetMapping("/bankpayment/get/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public BankPayment getBankPaymentDyId(@PathVariable Long id){
        return bankPaymentService.getBankPaymentById(id);
    }

    @DeleteMapping("/bankpayment/delete/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deleteBankPaymentById(@PathVariable Long id) {
        return bankPaymentService.deleteBankPaymentById(id);
    }

    @PutMapping("bankpayment/update")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public BankPayment updateBankPayment (@RequestBody BankPayment bankPayment){
        return bankPaymentService.updateBankPayment(bankPayment);
    }
}
