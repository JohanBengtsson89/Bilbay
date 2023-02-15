package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_alternatives")
public class DeliveryAlternative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,updatable = false)
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "delivery_cost")
    private int deliveryCost;
    @Column(name = "estimated_delivery")
    private String estimatedDelivery;

    @OneToMany(targetEntity = DeliveryPaymentTransaction.class, mappedBy = "deliveryAlternatives")
    private List<DeliveryPaymentTransaction> deliveryPaymentTransactions= new ArrayList<>();


    public DeliveryAlternative() {
    }

    public DeliveryAlternative(List<DeliveryPaymentTransaction> deliveryPaymentTransactions) {
        this.deliveryPaymentTransactions = deliveryPaymentTransactions;
    }

    public DeliveryAlternative(int id, String companyName, int deliveryCost, String estimatedDelivery) {
        this.id = id;
        this.companyName = companyName;
        this.deliveryCost = deliveryCost;
        this.estimatedDelivery = estimatedDelivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
}

