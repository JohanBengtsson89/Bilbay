package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuctionService<T> {
    public T findById (Long id);

    public T create(T entity);

    public List<T> findAll();

}
