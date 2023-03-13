package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Order;
import com.BilBay.bilbay.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).get();
    }

    public Order updateOrder (Order order){
        return orderRepository.save(order);
    }

    public String deleteOrderById(Long id){
         orderRepository.deleteById(id);
        return "Deleted order";
    }
}
