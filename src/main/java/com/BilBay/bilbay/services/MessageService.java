package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.PaymentTransaction;
import org.springframework.stereotype.Service;
@Service
public class MessageService {

    public void sendPaymentReminder(PaymentTransaction paymentTransaction) {

        System.out.println("An email sent to the buyer as a payment reminder: " + paymentTransaction.getBuyer().getFirstName()

                + " " + paymentTransaction.getBuyer().getLastName());
    }

}
