package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.CardPayment;
import com.BilBay.bilbay.repositories.CardPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CardPaymentService {

    @Autowired
    CardPaymentRepository cardPaymentRepository;

    public CardPayment createCardPayment(CardPayment cardPayment){
        return cardPaymentRepository.save(cardPayment);
    }

    public CardPayment findCardPaymentById(Long id){
        return cardPaymentRepository.findById(id).get();
    }

    public CardPayment updateCardPayment(CardPayment cardPayment){
        return cardPaymentRepository.save(cardPayment);
    }

    public String deleteCardPayment(Long id){
        cardPaymentRepository.deleteById(id);
        return "Card payment has been deleted";

    }
}
