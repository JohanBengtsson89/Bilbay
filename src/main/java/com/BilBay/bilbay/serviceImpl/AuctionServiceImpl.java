package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.repositories.BidRepository;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService<Auction> {

    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    BidRepository bidRepository;
    @Override
    public Auction create(Auction auction) {
        return auctionRepository.save(auction);
    }
    @Override
    public Auction findById(Long id) {
        return auctionRepository.findById(id).get();
    }


    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }


    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }



    public void deactivateProductAuction(Long id, boolean isActive){
        auctionRepository.deactivateProductAuction(isActive, id);

    }

    public Bid getHighestBid(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionIdOrderByBidAmountDesc(auctionId);
        if (bids.isEmpty()) {
            return null;
        }
        return bids.get(0);
    }

    public List<Bid> getAllBids(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    }

}
