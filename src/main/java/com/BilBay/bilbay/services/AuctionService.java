package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    private BidRepository bidRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction findAuctionById (Long id){
        return auctionRepository.findById(id).get();
    }


    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }


    public Bid getHighestBid(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionIdOrderByBidAmountDesc(auctionId);
        if (bids.isEmpty()) {
            return null;
        }
        return bids.get(0);
    }

    public String deleteAuctionById(Long id){
        auctionRepository.deleteById(id);
        return "auction deleted";
    }


    /*public List<Bid> findAllBidsOnAuction(Auction auction){
        return auctionRepository.findAllBidsOnAuction(auction.getId());
    }*/
}
