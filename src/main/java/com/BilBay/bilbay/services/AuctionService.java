package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction findAuctionById (Long id){
        return auctionRepository.findById(id).get();
    }

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }
    public Auction deactivateProductAuction(Long id, boolean isActive){
       return auctionRepository.deactivateProductAuction(id, isActive);

    }
    /*public List<Bid> findAllBidsOnAuction(Auction auction){
        return auctionRepository.findAllBidsOnAuction(auction.getId());
    }*/
}
