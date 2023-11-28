package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Order;


public interface OrderService {

    Order createOrder(Order order);
    Order getOrder(Long id);
    Order updateOrder(Order order);
    String deleteOrder(Long id);
}
