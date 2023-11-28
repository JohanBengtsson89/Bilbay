package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Order;
import com.BilBay.bilbay.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Order createOrder (@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("order/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Order getOrderById (@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @PutMapping("order/update")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Order updateOrder (@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("order/delete/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public void deleteOrderById (@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
