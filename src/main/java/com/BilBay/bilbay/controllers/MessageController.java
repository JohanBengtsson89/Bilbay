package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.PaymentTransaction;
import com.BilBay.bilbay.repositories.PaymentTransactionRepository;
import com.BilBay.bilbay.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Configuration
@EnableScheduling
@RestController
@RequestMapping("/api/auth/")
public class MessageController {
    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;
    @Autowired
    MessageService messageService;
    @GetMapping("reminding-message")
    @PreAuthorize("hasRole('ADMIN')")
    //this function will be executed every day at midnight to.
    @Scheduled(cron = "5 0 0 1 * *", zone = "Europe/Stockholm")
    public ResponseEntity<String> sendPaymentReminders() {
        //this will check the status of payment. if false within 30 days, a message will be sent to the buyer.
        LocalDate checkPaymentStatus = LocalDate.now().minusDays(30);
        List<PaymentTransaction> buyers = paymentTransactionRepository.findBySuccessfulAndCreatedAt(false, checkPaymentStatus);
        for (PaymentTransaction paymentTransaction : buyers) {
            messageService.sendPaymentReminder(paymentTransaction);
        }
        return ResponseEntity.ok(String.format("Sent reminding email to %d customers.", buyers.size()));
    }
}
