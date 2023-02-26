package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BidService {

    @Autowired
    BidRepository bidRepository;

    public Bid createBid(Bid bid){
        return bidRepository.save(bid);
    }

    public Bid getBidByID(Long id) {
        return bidRepository.findById(id).get();
    }

    public List<Bid> findAllBidsByAuction (Long id) {
        return bidRepository.findAllBidsByAuction(id);
    }
}
