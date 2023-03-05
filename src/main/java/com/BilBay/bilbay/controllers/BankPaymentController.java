package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.BankPayment;
import com.BilBay.bilbay.services.BankPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BankPaymentController {

    @Autowired
    BankPaymentService bankPaymentService;

    @PostMapping("/bankpayment")
    public BankPayment createBankpayment(@RequestBody BankPayment bankPayment){
        return bankPaymentService.createBankPayment(bankPayment);
    }

    @GetMapping("/bankpayment/get/{id}")
    public BankPayment getBankPaymentDyId(@PathVariable Long id){
        return bankPaymentService.getBankPaymentById(id);
    }

    @DeleteMapping("/bankpayment/delete/{id}")
    public String deleteBankPaymentById(@PathVariable Long id) {
        return bankPaymentService.deleteBankPaymentById(id);
    }

    @PutMapping("bankpayment/update")
    public BankPayment updateBankPayment (@RequestBody BankPayment bankPayment){
        return bankPaymentService.updateBankPayment(bankPayment);
    }
}
