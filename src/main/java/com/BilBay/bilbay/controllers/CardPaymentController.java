package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.CardPayment;
import com.BilBay.bilbay.repositories.CardPaymentRepository;
import com.BilBay.bilbay.services.CardPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cardpayment")
public class CardPaymentController {

    @Autowired
    CardPaymentService cardPaymentService;
    @Autowired
    private CardPaymentRepository cardPaymentRepository;

    @PostMapping("")
    public CardPayment createCardPayment (@RequestBody CardPayment cardPayment){
        return cardPaymentService.createCardPayment(cardPayment);
    }

    @GetMapping("/{id}")
    public CardPayment findCardPaymentById(@PathVariable Long id){
        return cardPaymentService.findCardPaymentById(id);
    }

    @PutMapping("/update")
    public CardPayment updateCardPayment(@RequestBody CardPayment cardPayment){
        return cardPaymentService.updateCardPayment(cardPayment);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCardPayment(@PathVariable Long id){
        return cardPaymentService.deleteCardPayment(id);
    }
}
