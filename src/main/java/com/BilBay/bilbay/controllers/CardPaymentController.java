package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.CardPayment;
import com.BilBay.bilbay.repositories.CardPaymentRepository;
import com.BilBay.bilbay.services.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class CardPaymentController {

    @Autowired
    CardPaymentService cardPaymentService;
    @Autowired
    private CardPaymentRepository cardPaymentRepository;

    @PostMapping("cardpayment")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public CardPayment createCardPayment (@RequestBody CardPayment cardPayment){
        return cardPaymentService.createCardPayment(cardPayment);
    }

    @GetMapping("cardpayment/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public CardPayment findCardPaymentById(@PathVariable Long id){
        return cardPaymentService.findCardPaymentById(id);
    }

    @PutMapping("cardpayment/update")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public CardPayment updateCardPayment(@RequestBody CardPayment cardPayment){
        return cardPaymentService.updateCardPayment(cardPayment);
    }
    @DeleteMapping("cardpayment/delete/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deleteCardPayment(@PathVariable Long id){
        return cardPaymentService.deleteCardPayment(id);
    }
}
